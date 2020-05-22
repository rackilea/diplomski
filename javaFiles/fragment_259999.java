import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class NewOrderFilesValidator implements Validator {

    private static final String MIME_TYPE_PDF = "application/pdf";
    private static final long ALLOWED_SIZE = 3 * 1024 * 1024;

    @Override
    public void validate(Object target, Errors errors) {
        if (target == null) {
            return;
        }

        NewOrderFilesDTO newOrderFilesDTO = (NewOrderFilesDTO) target;
        List<MultipartFile> newOrderFiles = newOrderFilesDTO.getFiles();

        if (isEmpty(newOrderFiles)) {
            return;
        }

        for (MultipartFile file : newOrderFiles) {
            if (!MIME_TYPE_PDF.equals(file.getContentType())) {
                errors.rejectValue(file.getName(), file.getName(), "'application/pdf' files allowed only!");
            }

            if (file.getSize() > ALLOWED_SIZE) {
                errors.rejectValue(file.getName(), file.getName(), "File size allowed up to 3MB!");
            }
        }
    }

    @Override
    public boolean supports(Class<?> cls) {
        return NewOrderFilesDTO.class.equals(cls);
    }
}