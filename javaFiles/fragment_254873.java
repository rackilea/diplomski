case class GetEsVersionQuery(esClient: Client) {
  lazy val p = promise[NodesInfoResponse]()

  esClient
    .admin()
    .cluster()
    .prepareNodesInfo()
    .all()
    .execute()
    .addListener(new ActionListener[NodesInfoResponse] {

    def onFailure(e: Throwable) = {
      p failure e
    }

    def onResponse(response: NodesInfoResponse) = p success response
  })

  def execute: Future[NodesInfoResponse] = p.future
}

def testElasticsearchVersion: Future[Boolean] = {
    GetEsVersionQuery(esClient).execute map {
      esVersion => {
        val nodes = esVersion.iterator().toList
        nodes forall(node => node.getVersion.after(Version.V_0_90_5))
      }
    } recover {
      case e: Throwable => false
    }
  }
}