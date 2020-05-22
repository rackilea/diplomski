package controllers

import play.api._
import libs.ws.WS
import play.api.mvc._

object Application extends Controller {

  def getImage = Action {
    Async {
      WS.url("http://someimageserver/myimage.png").get().map { r =>
        Ok(r.getAHCResponse.getResponseBodyAsBytes).as("image/png")
      }
    }
  }

}