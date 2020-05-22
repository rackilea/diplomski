public class MyHazelcastCacheTest {
    static {
        // set unit test time travelling clock
        System.setProperty(ClockProperties.HAZELCAST_CLOCK_IMPL, TimeTravellingStaticClock.class.getName());
    }

    private void timeTravel(Clock clock) {
        TimeTravellingStaticClock.timeTravel(clock);
    }

    private void undoTimeTravel() {
        TimeTravellingStaticClock.undoTimeTravel();
    }

    private static class TimeTravellingStaticClock extends com.hazelcast.util.Clock.ClockImpl {
        private static Clock sClock = Clock.systemUTC();

        public TimeTravellingStaticClock() {
            // nothing
        }

        public static void timeTravel(Clock clock) {
            sClock = clock;
        }

        public static void undoTimeTravel() {
            sClock = Clock.systemUTC();
        }

        @Override
        protected long currentTimeMillis() {
            return sClock.millis();
        }
    }
}