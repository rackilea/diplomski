class MyServiceImplementationUnitTest extends Specification {

  def Repository repository = Mock(Repository)

  @Subject MyService service = new MyService(
      ...
      repository // the mock      
  )

  // an example guidelines for a possible test
  def "this is a test"() {
    given: "an input object"
      def inputObject = SMTH
    when: "we call update method with that object"
      service.update(inputObject)
    then: "repository's update method is called once with expected parameter"
      1 * repository.update(inputObject)
  }
}