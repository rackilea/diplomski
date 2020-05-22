@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Autowired
    private MessageSource messageSource;

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Locale locale = LocaleContextHolder.getLocale();
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        errorAttributes.put("timestamp", new Date());
        addStatus(errorAttributes, requestAttributes);

        Throwable throwable = getError(requestAttributes);      
        if (throwable instanceof BindingResult) {
            addErrors(errorAttributes, (BindingResult) throwable, locale);
        } else if (throwable instanceof MethodArgumentNotValidException) {
            addErrors(errorAttributes, ((MethodArgumentNotValidException) throwable).getBindingResult(), locale);
        } else if (throwable instanceof InvalidFormatException) {
            addErrors(errorAttributes, (InvalidFormatException) throwable, locale);

        }
        return errorAttributes;
    }

    private void addStatus(Map<String, Object> errorAttributes,
            RequestAttributes requestAttributes) {
        Integer status = getAttribute(requestAttributes,
                "javax.servlet.error.status_code");
        if (status == null) {
            errorAttributes.put("status", 999);
            errorAttributes.put("error", "None");
            return;
        }
        errorAttributes.put("status", status);
        try {
            errorAttributes.put("error", HttpStatus.valueOf(status).getReasonPhrase());
        }
        catch (Exception ex) {
            // Unable to obtain a reason
            errorAttributes.put("error", "Http Status " + status);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
        return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }

    private void addErrors(
            Map<String, Object> errorAttributes, BindingResult bindingResult, Locale locale) {
        List<ErrorDTO> errors = new ArrayList<>();
        for (ObjectError error : bindingResult.getAllErrors()) {
            ErrorDTO e = new ErrorDTO();
            e.setCode(error.getCode());
            e.setMessage(localizedMessage(error, locale));

            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                e.setField(fieldError.getField());
                e.setRejectedValue(fieldError.getRejectedValue());
            }
            errors.add(e);
        }
        errorAttributes.put("errors", errors);
    }

    private String getInvalidFormatExceptionFieldName(InvalidFormatException ex) {

        for (JsonMappingException.Reference r : ex.getPath()) {
            return r.getFieldName();
        }

        return null;
    }

    private void addErrors(
            Map<String, Object> errorAttributes, InvalidFormatException ex, Locale locale) {
        List<ErrorDTO> errors = new ArrayList<>();

        ErrorDTO e = new ErrorDTO();
        e.setCode("InvalidFormatException");
        String message = localizedMessage(
                "InvalidFormatException", 
                new Object[] {ex.getTargetType().getName(), ex.getValue()},
                locale);
        e.setMessage(message);
        e.setField(getInvalidFormatExceptionFieldName(ex));
        e.setRejectedValue(ex.getValue());
        errors.add(e);
        errorAttributes.put("errors", errors);

    }

    private String localizedMessage(ObjectError error, Locale locale) {
        return messageSource.getMessage(error, locale);
    }

    private String localizedMessage(String message, Object[] args, Locale locale) {
        return messageSource.getMessage(message, args, locale);
    }
}