import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class I18nUtil {

    @Autowired
    private MessageSource messageSource;

    public String get(String code) {
        try {
            MessageSourceAccessor accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
            return accessor.getMessage(code);
        } catch (NoSuchMessageException nsme) {
            log.info("Message not found in localization: " + code);
            return code;
        }
    }
}