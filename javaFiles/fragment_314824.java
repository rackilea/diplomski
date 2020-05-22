import org.joda.time.Period;

class Normalize {
        public static void main(String[] args) {
                Period period = new Period(1325965615539L);
                System.out.println(period);
                System.out.println(period.normalizedStandard());
        }
}

// outputs
PT368323H46M55.539S
P2192W2DT19H46M55.539S