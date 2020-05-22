package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

import java.io.IOException;

public final class BooleanDeserializerIgnoreCase extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Boolean> {
    private static final long serialVersionUID = 1L;

    public final static BooleanDeserializerIgnoreCase primitiveInstance = new BooleanDeserializerIgnoreCase(Boolean.TYPE, Boolean.FALSE);
    public final static BooleanDeserializerIgnoreCase wrapperInstance = new BooleanDeserializerIgnoreCase(Boolean.class, null);

    public BooleanDeserializerIgnoreCase(Class<Boolean> cls, Boolean nvl) {
        super(cls, nvl, Boolean.FALSE);
    }

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return _parseBoolean(p, ctxt);
    }

    // Since we can never have type info ("natural type"; String, Boolean, Integer, Double):
    // (is it an error to even call this version?)
    @Override
    public Boolean deserializeWithType(JsonParser p, DeserializationContext ctxt,
                                       TypeDeserializer typeDeserializer)
            throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return _parseBoolean(p, ctxt);
    }

    protected final Boolean _parseBoolean(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_NULL) {
            return (Boolean) _coerceNullToken(ctxt, _primitive);
        }
        if (t == JsonToken.START_ARRAY) { // unwrapping?
            return _deserializeFromArray(p, ctxt);
        }
        // should accept ints too, (0 == false, otherwise true)
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return Boolean.valueOf(_parseBooleanFromInt(p, ctxt));
        }
        // And finally, let's allow Strings to be converted too
        if (t == JsonToken.VALUE_STRING) {
            return _deserializeFromString(p, ctxt);
        }
        // usually caller should have handled but:
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        // Otherwise, no can do:
        return (Boolean) ctxt.handleUnexpectedToken(_valueClass, p);
    }

    protected final Boolean _deserializeFromString(JsonParser p, DeserializationContext ctxt) throws IOException {
        String text = p.getText().trim();

        if (ctxt.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(text)) {
                return Boolean.TRUE;
            }
            if (Boolean.FALSE.toString().equalsIgnoreCase(text)) {
                return Boolean.FALSE;
            }
        } else {
            if ("true".equals(text) || "True".equals(text)) {
                _verifyStringForScalarCoercion(ctxt, text);
                return Boolean.TRUE;
            }
            if ("false".equals(text) || "False".equals(text)) {
                _verifyStringForScalarCoercion(ctxt, text);
                return Boolean.FALSE;
            }
            if (text.length() == 0) {
                return (Boolean) _coerceEmptyString(ctxt, _primitive);
            }
            if (_hasTextualNull(text)) {
                return (Boolean) _coerceTextualNull(ctxt, _primitive);
            }
        }
        return (Boolean) ctxt.handleWeirdStringValue(_valueClass, text,
                "only \"true\" or \"false\" recognized");
    }
}