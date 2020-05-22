LinkedHashMap<String, float[]> fData;
double data[][] = new double[fData.size()][];
int i = 0;

for( String key in fData.keys() ) {
    float[] tValue = fData.get(key);
    data[i] = new double[ tValue.length ];
    for (int j = 0; j < tValue.length; j++) {
        data[i][j] = tValue[j];
    }
    i++;
}