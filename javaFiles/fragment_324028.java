val webRoute = path("web") {
    get {
      entity(as[String]) {
        thePath =>
          getFromResourceDirectory(thePath)
      }
    }
  }