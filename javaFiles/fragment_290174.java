import java.util.Map;
    import org.apache.commons.lang.StringUtils;
    import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
    import org.springframework.stereotype.Component;
    import org.springframework.web.context.request.WebRequest;



     @Component
        public class ExtendedDefaultErrorAttributes extends DefaultErrorAttributes {
          @Override
          public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
            final Map<String, Object> errorAttributes =
                super.getErrorAttributes(webRequest, includeStackTrace);

            // MethodArgumentNotValidException includes errors key
            Object errors = errorAttributes.get("errors");
             // .. now you can do whatever you want here... something like completely remove it.  
            if (errors != null) {
              errorAttributes.remove("errors");
            }


   // In here for what you are looking for , you should be doing something like //below, just as an example, but do it properly, I just typed it without checking:

     List<ObjectError> errors = (List<ObjectError>) errorAttributes.get("errors");

        errors.get(0).getCodes()[0].replaceAll("customerDto", "customer");

            return errorAttributes;
          }
        }