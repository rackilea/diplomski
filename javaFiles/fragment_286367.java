import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@ConfigurationProperties("test.properties")
@Component
public class TestProperties implements Validator {

    private String myProp;

    public String getMyProp()
    {
        return myProp;
    }

    public void setMyProp( String myProp )
    {
        this.myProp = myProp;
    }

    public boolean supports( Class<?> clazz )
    {
        return clazz == TestProperties.class;
    }

    public void validate( Object target, Errors errors )
    {
        ValidationUtils.rejectIfEmpty( errors, "myProp", "myProp.empty" );

        TestProperties properties = (TestProperties) target;

        if ( !"validThing".equals( properties.getMyProp() ) ) {
            errors.rejectValue( "myProp", "Not a valid thing" );
        } 
    }
}