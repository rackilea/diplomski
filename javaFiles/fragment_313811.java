@Override
     public Instant plus(long amountToAdd, TemporalUnit unit) {
         if (unit instanceof ChronoUnit) {
             switch ((ChronoUnit) unit) {
                 case NANOS: return plusNanos(amountToAdd);
                 case MICROS: return plus(amountToAdd / 1000_000, (amountToAdd % 1000_000) * 1000);
                 case MILLIS: return plusMillis(amountToAdd);
                 case SECONDS: return plusSeconds(amountToAdd);
                 case MINUTES: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_MINUTE));
                 case HOURS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_HOUR));
                 case HALF_DAYS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_DAY / 2));
                 case DAYS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_DAY));
             }
             throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
         }
         return unit.addTo(this, amountToAdd);
     }