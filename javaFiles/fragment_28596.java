import groovy.grape.Grape

Grape.metaClass.static.grab = {String endorsed ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}

Grape.metaClass.static.grab = {Map dependency ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}

Grape.metaClass.static.grab = {Map args, Map dependency ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}

def source1 = '''
println('This is a nice safe Groovy script.')
'''

def source2 = '''
@Grab('commons-validator:commons-validator:1.4.1')

import org.apache.commons.validator.routines.EmailValidator

def emailValidator = EmailValidator.getInstance();

assert emailValidator.isValid('what.a.shame@us.elections.gov')
assert !emailValidator.isValid('an_invalid_emai_address')

println 'You should not see this message!'
'''

def script
def shell = new GroovyShell()

try {
    script = shell.parse(source1)
    script.run()
} catch (Exception e) { 
    assert false, "Oh, oh. That wasn't supposed to happen :("
}    

try {
    script = shell.parse(source2)
    assert false, "Oh, oh. That wasn't supposed to happen :("
} catch (ExceptionInInitializerError e) { 
    println 'Naughty script was blocked when parsed.'
}