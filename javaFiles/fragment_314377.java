case class HttpRequest(headers: Map[String, String], body: String, path: String)

object HttpRequest {

  def apply(builder: HttpRequest.Builder): HttpRequest = 
      HttpRequest(Map(builder.headers.toSeq: _*),
                  builder.body,
                  builder.path)

  class Builder {
    private[HttpRequest] val headers = new mutable.HashMap[String, String]()
    private[HttpRequest] var body: String = _
    private[HttpRequest] var path: String = _

    def addHeader(name: String, value: String): Builder = {
      headers.put(name, value)
      this
    }

    def body(b: String): Builder = {
      body = b
      this
    }

    def path(p: String): Builder = {
      this.path = p
      this
    }

    def build: HttpRequest = {
      HttpRequest(this)
    }
  }

  def builderFrom(request: HttpRequest): Builder = {
    val builder = new Builder().path(request.path).body(request.body)

    request.headers.foldLeft(builder){ (b,h) => b.addHeader(h._1, h._2) }
  }
}