package com.tivoli.api.application.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Workaround class for making JSR-303 annotation validation work for controller method parameters.
 * Check the issue <a href="https://jira.spring.io/browse/DATAREST-593">DATAREST-593</a>
 */
@ControllerAdvice
public class RequestBodyValidationProcessor extends RequestBodyAdviceAdapter {

    private final Validator validator;

    public RequestBodyValidationProcessor(@Autowired final Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean supports(final MethodParameter methodParameter, final Type targetType, final Class<? extends
            HttpMessageConverter<?>> converterType) {
        final Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
        for (final Annotation annotation : parameterAnnotations) {
            if (annotation.annotationType().equals(Valid.class)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object afterBodyRead(final Object body, final HttpInputMessage inputMessage, final MethodParameter
            parameter, final Type targetType, final Class<? extends HttpMessageConverter<?>> converterType) {
        final Object obj = super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
        final BindingResult bindingResult = new BeanPropertyBindingResult(obj, obj.getClass().getCanonicalName());
        validator.validate(obj, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ValidationException(createErrorMessage(bindingResult));
        }

        return obj;
    }

    private String createErrorMessage(final BindingResult bindingResult) {
        final StringBuilder stringBuilder = new StringBuilder("Invalid parameters specified.");
        if (bindingResult.getFieldErrors() != null && !bindingResult.getFieldErrors().isEmpty()) {
            stringBuilder.append(" Fields:");
            bindingResult.getFieldErrors().forEach(fieldError -> stringBuilder
                    .append(" [ ")
                    .append(fieldError.getField())
                    .append(" : ")
                    .append(fieldError.getRejectedValue())
                    .append(" ] "));
        } else if (bindingResult.getAllErrors() != null && !bindingResult.getAllErrors().isEmpty()) {
            final ObjectError objectError = bindingResult.getAllErrors().get(0); // get the first error
            stringBuilder.append(" Message: ")
                    .append(objectError.getDefaultMessage());
        }

        return stringBuilder.toString();
    }
}