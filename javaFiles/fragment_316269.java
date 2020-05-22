public interface ValueGetter
{
    public float get (DataStore source);
}

float[] aArray = getValuesAsArray(dataMap, new ValueGetter() {public float get (DataStore source) {return source.getA();}});
float[] bArray = getValuesAsArray(dataMap, new ValueGetter() {public float get (DataStore source) {return source.getB();}});
float[] cArray = getValuesAsArray(dataMap, new ValueGetter() {public float get (DataStore source) {return source.getC();}});