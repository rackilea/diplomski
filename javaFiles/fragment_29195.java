class SomeTest extends Specification {

    RestTemplate restTemplate = Mock {
        postForEntity(_, _, SomeResponse.class) >> new ResponseEntity(new SomeResponse(), HttpStatus.OK)
    }

    SomeService someService = new SomeService (  null, restTemplate);

    def "someTest"() {
        when:
        SomeResponse someResponse = someService.doSomePostRequest(new HttpEntity<>(new SomeBody(), new HttpHeaders()))
        then:
        someResponse == new SomeResponse()
    }
}