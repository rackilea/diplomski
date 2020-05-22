// src/main/groovy/demo/MyDateTimeConverter.groovy
package demo

import grails.databinding.converters.ValueConverter

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyDateTimeConverter implements ValueConverter {
    @Override
    boolean canConvert(Object value) {
        value instanceof String
    }

    @Override
    Object convert(Object value) {
        def fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        LocalDateTime.parse(value, fmt)
    }

    @Override
    Class<?> getTargetType() {
        LocalDateTime
    }
}