// Scala example

def accept = Action(parse.json) { implicit request =>
    render {
      case Accepts.Json() => Ok(Json.parse("""{"message" : "Thanks for sending and accepting JSON"}"""))
    }
  }