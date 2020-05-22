import static java.time.LocalDateTime.*;

public abstract class Jsr310Converters {
...
   public static enum DateToLocalDateTimeConverter implements Converter<Date, LocalDateTime> {

      INSTANCE;

      @Override
      public LocalDateTime convert(Date source) {
          return source == null ? null : ofInstant(source.toInstant(), ZoneId.systemDefault());
      }
  }
 ...
}