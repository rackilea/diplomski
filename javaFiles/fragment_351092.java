import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.chrono.GregorianChronology;

public final class EightHoursDayChronology extends AssembledChronology {

   private static final EightHoursDayChronology INSTANCE_UTC;

  static{
  INSTANCE_UTC = new EightHoursDayChronology(GregorianChronology.getInstanceUTC());
  }


  public static EightHoursDayChronology getInstance(){
       return INSTANCE_UTC  ;
  }

    private EightHoursDayChronology(Chronology base) {
        super(base, null);
    }

    @Override
   protected void assemble(org.joda.time.chrono.AssembledChronology.Fields fields) {

    int millisPerDay = 1000 * 60 * 60 * 8   ;
    fields.days = new PreciseDurationField(DurationFieldType.days(), millisPerDay)
  }

   @Override
  public Chronology withUTC() {
    return INSTANCE_UTC    ;
  }

    @Override
    public Chronology withZone(DateTimeZone zone) {
        throw new UnsupportedOperationException("Method was not implemented");
    }

    @Override
    public String toString() {
        return "EightHoursDayChronology";
    }

}