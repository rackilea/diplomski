package com.practice.rigz.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.practice.rigz.annotations.MyAnnotation;
import com.practice.rigz.model.Person;
import lombok.extern.java.Log;
import org.hibernate.validator.internal.util.privilegedactions.NewJaxbContext;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Log
@MyAnnotation
public class RequestMessageBodyReader implements MessageBodyReader<Person> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    log.info("IS READABLE...");
    return type == Person.class;
  }

  @Override
  public Person readFrom(Class<Person> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
    ObjectMapper mapper = new ObjectMapper();
    Person person = mapper.readValue(entityStream, Person.class);
    log.info("READ FROM...");
    return person;

  }
}