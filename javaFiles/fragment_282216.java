object ControllerA extends Controller{

  def ActionA = Action.async { implicit request =>
    var jsonRequest = request.body.asJson.get
    val uuid = (jsonRequest \ "uuid").as[String]
    log.info("in ActionA" + uuid)
    ControllerB.ActionB(request)
  }
}

object ControllerB extends Controller{
  def ActionB = Action { implicit request =>
    var jsonRequest = request.body.asJson.get
    val uuid = (jsonRequest \ "uuid").as[String]
    log.info("in ActionB " + uuid)
    try {
      Ok("i am ActionB with id {}"+uuid)
    } catch {
      case e: Exception =>
        log.error("Exception ", e)
        val status = Http.Status.INTERNAL_SERVER_ERROR
        InternalServerError(Json.obj("status" -> status, "msg" -> ServerResponseMessages.INTERNAL_SERVER_ERROR))
    }
  }
}