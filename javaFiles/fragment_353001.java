public MetaphoneDistance() {
    Metaphone metaphone = new Metaphone();
}

//I'm not really familiar with the library you mentioned, but I assume generateKeys performs a double metaphone?
public float getDistance(String str1, ,String str2) {
    String[] keys1 = metaphone.getKeys(str1);  
    String[] keys2 = metaphone.getKeys(str2);
    float result = 0;
    if (key1[0] == key2[0] || key1[0] == key2[1]) result += .5
    if (key1[1] == key2[0] || key1[1] == key2[1]) result += .5
    return result;
}