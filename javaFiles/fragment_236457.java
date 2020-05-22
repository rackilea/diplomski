import spock.lang.*

@TestFor(EncouragementService)
@Mock(User) //If you are accessing User domain object.
class EncouragementServiceSpec extends Specification{
  //def encouragementService //DO NOT NEED: mocked in @TestFor annotation

  void "test Encourage Users are properly handled"() {
      given: "List of Users"
          List<User> users = createUsers()

      when: "service is called"
          //"service" represents the grails service you are testing for
          service.encourageUsers(users) 

      then: "Expect something to happen"
          //Assertion goes here
  }

  private def createUsers(){
       return users //List<User>
  }
}