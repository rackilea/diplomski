package com.paandadb.test;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.MalformedParametersException;
import java.lang.reflect.Parameter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class Test {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new HackedParameterModule(JsonCreator.Mode.PROPERTIES));

        DateSettings settings = objectMapper.readValue("{\"ignoreDate\": false}", DateSettings.class);
        System.out.println(settings.ignoreDate);
    }

    public static class DateSettings {
        private final boolean ignoreDate;

        public DateSettings(boolean ignoreDate) {
          this.ignoreDate = ignoreDate;
        }

        public boolean isIgnoreDate() {
          return ignoreDate;
        }
      }

    // we need to hack this because `ParameterExtractor` is package private, so we can't extend this class
    public static class HackedAnnotationIntrospector extends ParameterNamesAnnotationIntrospector {
        private static final long serialVersionUID = 1L; 

        HackedAnnotationIntrospector(Mode creatorBinding, ParameterExtractor parameterExtractor) {
            super(creatorBinding, parameterExtractor);
        }
    }

    // we need to register a different introspector for the annotations
    public static class HackedParameterModule extends ParameterNamesModule {
        private static final long serialVersionUID = 1L;
        public HackedParameterModule(Mode properties) {
            super(properties);
        }

        @Override
        public void setupModule(SetupContext context) {
            super.setupModule(context);
            context.insertAnnotationIntrospector(new ParameterNamesAnnotationIntrospector(JsonCreator.Mode.DEFAULT, new ParameterExtractor()));
        }
    }

    // This is the hacked introspector that simply returns default instead of null 
    // you may want to make more checks here to make sure it works the way you want to and has no 
    // side effects. Same thing here - need to extend because of package private `ParameterExtractor`
    public static class ParameterNamesAnnotationIntrospector extends NopAnnotationIntrospector {
        private static final long serialVersionUID = 1L;

        private final JsonCreator.Mode creatorBinding;
        private final ParameterExtractor parameterExtractor;

        ParameterNamesAnnotationIntrospector(JsonCreator.Mode creatorBinding, ParameterExtractor parameterExtractor)
        {
            this.creatorBinding = creatorBinding;
            this.parameterExtractor = parameterExtractor;
        }

        @Override
        public String findImplicitPropertyName(AnnotatedMember m) {
            if (m instanceof AnnotatedParameter) {
                return findParameterName((AnnotatedParameter) m);
            }
            return null;
        }

        private String findParameterName(AnnotatedParameter annotatedParameter) {
            Parameter[] params;
            try {
                params = getParameters(annotatedParameter.getOwner());
            } catch (MalformedParametersException e) {
                return null;
            }

            Parameter p = params[annotatedParameter.getIndex()];
            return p.isNamePresent() ? p.getName() : null;
        }

        private Parameter[] getParameters(AnnotatedWithParams owner) {
            if (owner instanceof AnnotatedConstructor) {
                return parameterExtractor.getParameters(((AnnotatedConstructor) owner).getAnnotated());
            }
            if (owner instanceof AnnotatedMethod) {
                return parameterExtractor.getParameters(((AnnotatedMethod) owner).getAnnotated());
            }

            return null;
        }

        /*
        /**********************************************************
        /* Creator information handling
        /**********************************************************
         */

        @Override
        public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> config, Annotated a) {
            JsonCreator ann = _findAnnotation(a, JsonCreator.class);
            // THIS IS THE FIXING BIT
            // Note: I only enable this for your specific class, all other cases are handled in default manner 
            Class<?> rawType = a.getRawType();
            if(ann == null && rawType.isAssignableFrom(DateSettings.class)) { 
                return JsonCreator.Mode.DEFAULT;
            }
            if (ann != null) {
                JsonCreator.Mode mode = ann.mode();
                // but keep in mind that there may be explicit default for this module
                if ((creatorBinding != null)
                        && (mode == JsonCreator.Mode.DEFAULT)) {
                    mode = creatorBinding;
                }
                return mode;
            }
            return null;
        }

        // I left the other functions from the original code in to prevent breakage 
        @Override
        @Deprecated // remove AFTER 2.9
        public JsonCreator.Mode findCreatorBinding(Annotated a) {
            JsonCreator ann = _findAnnotation(a, JsonCreator.class);
            if (ann != null) {
                JsonCreator.Mode mode = ann.mode();
                if ((creatorBinding != null)
                        && (mode == JsonCreator.Mode.DEFAULT)) {
                    mode = creatorBinding;
                }
                return mode;
            }
            return creatorBinding;
        }

        @Override
        @Deprecated // since 2.9
        public boolean hasCreatorAnnotation(Annotated a)
        {
            // 02-Mar-2017, tatu: Copied from base AnnotationIntrospector
            JsonCreator ann = _findAnnotation(a, JsonCreator.class);
            if (ann != null) {
                return (ann.mode() != JsonCreator.Mode.DISABLED);
            }
            return false;
        }
    }

    // This is the package private class that does not allow for proper extending
    // which is why we had to copy a bunch of code 
    public static class ParameterExtractor {

        public Parameter[] getParameters(Executable executable) {
            return executable.getParameters();
        }
    }
}