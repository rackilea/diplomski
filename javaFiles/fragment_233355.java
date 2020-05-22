package controllers

import play.api._
import libs.iteratee.{Enumerator, Input, Iteratee, Concurrent}
import play.api.mvc._
import scala.collection.concurrent

object Application extends Controller {
  val streams = new concurrent.TrieMap[String,(Enumerator[Array[Byte]], Concurrent.Channel[Array[Byte]])]

  def index = Action {
    Ok(views.html.index())
  }

  def download(id: String) = Action {
    val (fileStream, fileInput) = Concurrent.broadcast[Array[Byte]]
    streams += id -> (fileStream, fileInput)
    Ok.stream {
      fileStream.onDoneEnumerating(streams -= id)
    }
  }

  def upload = Action(parse.multipartFormData(myPartHandler)) {
    request => Ok("banana!")
  }

  def myPartHandler: BodyParsers.parse.Multipart.PartHandler[MultipartFormData.FilePart[Result]] = {
    parse.Multipart.handleFilePart {
      case parse.Multipart.FileInfo(partName, filename, contentType) =>
        val (thisStream, thisInput) = streams(partName)

        Iteratee.fold[Array[Byte], Concurrent.Channel[Array[Byte]]](thisInput) { (inp, data) =>
          inp.push(data)
          inp
        }.mapDone { inp =>
          inp.push(Input.EOF)
          Ok("upload Done")
        }
    }
  }
}