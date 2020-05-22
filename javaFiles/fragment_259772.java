abstract class AuthorizingResource implements GroovyInterceptable {
    def invoked = []
    def validator = [credentialIsValid : { true }]

    void authorize(String credential) {
        if ( !validator.credentialIsValid(credential) ) {
            throw new RuntimeException(credential)
        }
    }

    def invokeMethod(String method, args) {
        if (method.toLowerCase().contains('fizz')) {
            metaClass.getMetaMethod('authorize', String).invoke(this, args[0])
            invoked.add( 'authorized ' + method )
        }
        return metaClass
            .getMetaMethod(method, args*.getClass() as Class[])
            .invoke(this, args)
    }
}

class Fizz { String name }

class FizzResource extends AuthorizingResource {
    List<Fizz> getAllFizzes(String credential) { ['all fizzes'] }
    Fizz getFizzById(String credential, Long id) { new Fizz(name: 'john doe') }
    def considerTheLillies() { 42  }
}

res = new FizzResource()
assert res.getAllFizzes('cred') == ['all fizzes']
assert res.considerTheLillies() == 42
assert res.getFizzById('cred', 10l).name == 'john doe'

assert res.invoked == ['authorized getAllFizzes', 'authorized getFizzById']