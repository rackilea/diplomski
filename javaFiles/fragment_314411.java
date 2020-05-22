package contact;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springmodules.validation.bean.converter.ErrorCodeConverter;

public class MyErrorCodeConverter implements ErrorCodeConverter {

    private Log log = LogFactory.getLog(MyErrorCodeConverter.class);

    @Override
    public String convertPropertyErrorCode(String errorCode, Class clazz, String property) {
        log.error(String.format("Property %s %s %s", errorCode, clazz.getClass().getName(), property));
        return errorCode;  // <------ use the errorCode only
    }

    @Override
    public String convertGlobalErrorCode(String errorCode, Class clazz) {
        log.error(String.format("Global %s %s", errorCode, clazz.getClass().getName()));
        return errorCode;
    }
}