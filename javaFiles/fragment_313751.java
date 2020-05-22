package org.foo.logging.internal;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Objects;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class WallClockTimeFilter implements Filter
{
    private static final TemporalQuery<Boolean> BUSINESS_HOURS
                                            = new BusinessHours();

    static class BusinessHours implements TemporalQuery<Boolean>
    {
        private static final LocalTime FROM = LocalTime.of(9, 0);
        private static final LocalTime TO = LocalTime.of(17, 0);

        @Override
        public Boolean queryFrom(TemporalAccessor temporal)
        {
            final LocalTime now = LocalTime.from(temporal);
            return (now.isAfter(FROM) && now.isBefore(TO));
        }
    }

    @Override
    public boolean isLoggable(LogRecord record)
    {
        Objects.requireNonNull(record, "record");
        final LocalTime now = LocalTime.ofInstant(record.getInstant(),
                                                ZoneId.systemDefault());
        return now.query(BUSINESS_HOURS);
    }
}