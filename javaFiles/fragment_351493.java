package com.hazelcast.util;

...

public final class Clock {

    private static final ClockImpl CLOCK;
    private Clock() {
    }

    /** Returns the current time in ms for the configured {@link ClockImpl} */
    public static long currentTimeMillis() {
        return CLOCK.currentTimeMillis();
    }

    static {
        CLOCK = createClock();
    }

    static ClockImpl createClock() {
        String clockImplClassName = System.getProperty(ClockProperties.HAZELCAST_CLOCK_IMPL);
        if (clockImplClassName != null) {
            try {
                return ClassLoaderUtil.newInstance(null, clockImplClassName);
            } catch (Exception e) {
                throw rethrow(e);
            }
        }

        String clockOffset = System.getProperty(ClockProperties.HAZELCAST_CLOCK_OFFSET);
        long offset = 0L;
        if (clockOffset != null) {
            try {
                offset = Long.parseLong(clockOffset);
            } catch (NumberFormatException e) {
                throw rethrow(e);
            }
        }
        if (offset != 0L) {
            return new SystemOffsetClock(offset);
        }

        return new SystemClock();
    }
}