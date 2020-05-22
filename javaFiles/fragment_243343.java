import dispatch._
import spray.json._
import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors
import scala.concurrent.Await
import scala.concurrent.duration._
import com.ning.http.client.Cookie

case class CodeRequest(consumer_key:String, redirect_uri:String = "fake:uri")
object CodeRequest
case class CodeResponse(code:String)
object CodeResponse

case class AuthRequest(consumer_key:String, code:String)
object AuthRequest
case class AuthResponse(access_token:String, username:String)
object AuthResponse

object PocketJsonProtocol extends DefaultJsonProtocol {
  implicit val codeRequestFormat = jsonFormat2(CodeRequest.apply)
  implicit val codeResponseFormat = jsonFormat1(CodeResponse.apply)
  implicit val authRequestFormat = jsonFormat2(AuthRequest.apply)
  implicit val authResponseFormat = jsonFormat2(AuthResponse.apply)  
}

object PocketAuth {
  import PocketJsonProtocol._
  val JsonHeaders = Map("X-Accept" -> "application/json", "Content-Type" -> "application/json; charset=UTF-8")
  implicit val EC = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

  def authenticate(consumerKey:String, userId:String) = {
    val fut = for{
      codeResp <- requestCode(consumerKey)
      _ <- activateToken(codeResp, userId)
      authResp <- requestAuth(consumerKey, codeResp)
    } yield{
      JsonParser(authResp).convertTo[AuthResponse]
    }

    val auth = Await.result(fut, 5 seconds)
    auth.access_token
  }

  def requestCode(key:String) = {
    val req = url("https://getpocket.com/v3/oauth/request") <:< JsonHeaders << CodeRequest(key).toJson.toString
    Http(req.POST OK as.String).map(JsonParser(_).convertTo[CodeResponse])
  }

  def activateToken(codeResp:CodeResponse, userId:String) = {
    val req = (url("https://getpocket.com/auth/authorize") <<? Map("request_token" -> codeResp.code, "redirect_uri" -> "foo")).addCookie(
      new Cookie(".getpocket.com", "sess_user_id", userId, "/", 100, false))
    Http(req)
  }

  def requestAuth(key:String, codeResp:CodeResponse) = {
    val req = url("https://getpocket.com/v3/oauth/authorize") <:< JsonHeaders << AuthRequest(key, codeResp.code).toJson.toString
    Http(req.POST OK as.String)
  }

}