/*
 * Get the Jira project ID for a project like 'ABC'
 */
def int getJiraProjectid(String jiraProject) {

 int existingProjectId = 0

  def json = [jiraprojectRequest()]
  json.each {
    existingProjectId = it."id".toInteger()
    //println "$existingVersionId"
 }
  if (existingProjectId == 0)
   throw new GradleException("Existing project ${jiraProject} was not found in JIRA")

 return existingProjectId
}

def Map jiraprojectRequest() {
  Map jsonResultList = null
  def jira = new HTTPBuilder("${jiraURL}/rest/api/2/project/${jiraProject}", ContentType.JSON)
  jira.request(groovyx.net.http.Method.GET) { req ->
    headers.'Authorization' = authHeader()

    response.success = { resp, json ->
      project.getLogger().info('[jira] Response data: -----')
      project.getLogger().info("[jira] $json")
      project.getLogger().info('\n--------------------')
      jsonResultList = json
    }

    response.failure = { resp ->
      throw new GradleException("Get JIRA versions failure - jiraGetVersions(): ${resp.status} - ${resp.statusLine.reasonPhrase}")
    }
  }
  return jsonResultList
}