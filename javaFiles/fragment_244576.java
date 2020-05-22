@TestFor(TokenService)
    class TokenServiceSpec extends Specification {

def setup() {
}

def cleanup() {
}

def "test generateToken"() {
    expect: 
    service.generateToken(5).length() == 5
   }
}