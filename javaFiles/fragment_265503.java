int zeroesRemaining = 16 - result.length();
StringBuilder tempBuilder = new StringBuilder(result);
for (int i = 0; i < zeroesRemaining; i++) {
    tempBuilder.insert(0, 0); //inserts the integer 0 at position 0 of the stringbuilder
}
return tempBuilder.toString(); //converts to string format