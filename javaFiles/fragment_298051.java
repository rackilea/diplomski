public class DateTimeRange implements Iterable<LocalDateTime> {


      private final LocalDateTime startDateTime;
      private final LocalDateTime endDateTime;

      public DateTimeRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        //check that range is valid (null, start < end)
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
      }


      @Override
      public Iterator<LocalDateTime> iterator() {
         return stream().iterator();
      }

      public Stream<LocalDateTime> stream() {
         return Stream.iterate(startDateTime, d -> d.plusMinutes(1))
                     .limit(ChronoUnit.MINUTES.between(startDateTime, endDateTime) + 1);
      }
   }