package de.scrum_master.stackoverflow.q58101434

import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Unroll

class MyRestApiTest extends Specification {
  @Unroll
  def "API returns status code #statusCode"() {
    given: "prepare mocks + spy"
    RequestEntity<String> requestEntity = Mock()
    ResponseEntity<String> responseEntity = Mock() {
      getStatusCode() >> httpStatus
    }
    MyRestApi myRestApi = Spy() {
      createRequestEntity(_, _) >> requestEntity
      executeRequest(_, _) >> responseEntity
    }

    when: "execute API method"
    def result = myRestApi.api()

    then: "check expected results"
    // This actually only tests mockfunctionality, your real test would look differently
    statusCode == result.value()
    reasonPhrase == result.reasonPhrase

    where:
    httpStatus                   | statusCode | reasonPhrase
    HttpStatus.OK                | 200        | "OK"
    HttpStatus.MOVED_PERMANENTLY | 301        | "Moved Permanently"
    HttpStatus.UNAUTHORIZED      | 401        | "Unauthorized"
  }
}