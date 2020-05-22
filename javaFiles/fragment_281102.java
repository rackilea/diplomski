package de.scrum_master.requests

import de.scrum_master.query.DatabaseQuery
import spock.lang.Specification

class RequestProcessorTest extends Specification {
  //Class to be tested
  RequestProcessor requestProcessor

  //Dependencies
  DatabaseQuery dbquery

  def "Given a valid request, dbquery's executeQuery method is called" () {
    given: "a valid request"
    def queryRequest = '{"info1":"value1","info2":"value2","query":"select * from users"}'

    and: "mock the DBQuery class"
    dbquery = Mock(DatabaseQuery)
    //dbquery = Spy(DatabaseQuery, constructorArgs: [queryRequest])

    and: "create a new request"
    requestProcessor = new RequestProcessor(queryRequest)
    requestProcessor.databaseQuery = dbquery

    when: "the request is processed"
    requestProcessor.processRequest()

    then: "dbquery executeQuery method is called"
    1 * dbquery.executeQuery(_ as String)
  }
}