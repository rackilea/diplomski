import java.lang.annotation.*;
import javax.management.DescriptorKey;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Obfuscated {
  @DescriptorKey("obfuscated")
  boolean value() default true;
}