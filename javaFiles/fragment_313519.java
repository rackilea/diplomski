import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // allow this annotation to be set only for fields
public @interface GoodInt {

}