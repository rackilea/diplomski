package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ShortInstantSerializer extends InstantSerializerBase<Instant> {

    private ToLongFunction<Instant> getEpochSeconds = Instant::getEpochSecond;
    private ToIntFunction<Instant> getNanoseconds = i -> i.getNano() / 1_000_000;

    public ShortInstantSerializer() {
        super(Instant.class, Instant::toEpochMilli, Instant::getEpochSecond, Instant::getNano, null);
    }

    protected ShortInstantSerializer(ShortInstantSerializer base, Boolean useTimestamp, Boolean useNanoseconds, DateTimeFormatter formatter) {
        super(base, useTimestamp, useNanoseconds, formatter);
    }

    @Override
    protected JSR310FormattedSerializerBase<?> withFormat(Boolean useTimestamp, DateTimeFormatter formatter, JsonFormat.Shape shape) {
        return new ShortInstantSerializer(this, useTimestamp, null, formatter);
    }

    @Override
    public void serialize(Instant value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        if (useTimestamp(provider)) {
            if (useNanoseconds(provider)) {
                String concatenated = getEpochSeconds.applyAsLong(value) + "." + getNanoseconds.applyAsInt(value);
                generator.writeNumber(new BigDecimal(concatenated));
                return;
            }
        }

        super.serialize(value, generator, provider);
    }
}