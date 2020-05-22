public class HolidayTransformer  extends Transformer<Holiday> {

@Override
public Holiday transform(String value) {
    try {
        return Holiday.fromString(value);
    } catch (Exception e) {
        fail("Could not convert from value");
        return null;
    }
}

}