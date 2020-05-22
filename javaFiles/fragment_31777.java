public class AccumulatedTimeFormat extends Format {

@Override
public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
    Long totalSeconds;

    if(obj instanceof Byte) {
        totalSeconds=((Byte)obj).longValue();
    } else if(obj instanceof Short) {
        totalSeconds=((Short)obj).longValue();
    } else if(obj instanceof Integer) {
        totalSeconds=((Integer)obj).longValue();
    } else if(obj instanceof Long) {
        totalSeconds=((Long)obj);
    } else {
        throw new IllegalArgumentException("Cannot format given Object as an accumulated-time String!");
    }

    long ss = Math.abs(totalSeconds) % 60;
    long mm = (Math.abs(totalSeconds) / 60) % 60;
    long h = (Math.abs(totalSeconds) / 60) / 60;

    if(totalSeconds<0) {
        toAppendTo.append('-');
    }
    toAppendTo.append(String.format("%d:%02d:%02d", h, mm, ss));

    return toAppendTo;
}

@Override
public Object parseObject(String source, ParsePosition pos) {
    //TODO Implement if needed!
    return null;
}