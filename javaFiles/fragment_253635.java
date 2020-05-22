object Global extends GlobalSettings {

  override def onRouteRequest(request: RequestHeader): Option[Handler] = {
    if (request.session.get("site").isEmpty){
      val id = models.Site.getSiteIDFromURL(request.host)
      request.session.+("site" -> id)
    }
    super.onRouteRequest(request)
  }

}