@groovy.lang.Grab(module = 'commons-validator', group = 'commons-validator', version = '1.4.1')
import org.apache.commons.validator.routines.EmailValidator as EmailValidator

public class script1440223706571 extends groovy.lang.Script { 

    private static org.codehaus.groovy.reflection.ClassInfo $staticClassInfo 
    public static transient boolean __$stMC 

    public script1440223706571() {
    }

    public script1440223706571(groovy.lang.Binding context) {
        super(context)
    }

    public static void main(java.lang.String[] args) {
        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1440223706571, args)
    }

    public java.lang.Object run() {
        java.lang.Object emailValidator = org.apache.commons.validator.routines.EmailValidator.getInstance()
        assert emailValidator.isValid('what.a.shame@us.elections.gov') : null
        assert !(emailValidator.isValid('an_invalid_emai_address')) : null
        return null
    }

    static { 
        groovy.grape.Grape.grab([:], ['group': 'commons-validator', 'module': 'commons-validator', 'version': '1.4.1'])
    }

    protected groovy.lang.MetaClass $getStaticMetaClass() {
    }

}