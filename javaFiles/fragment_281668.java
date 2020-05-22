String[] latValues = latitude.split(" ");
float sum = 0;
for (int i = 0; i < latValues.length; i++) {              
    if (!latValues[i].equals("null"))
        sum = sum + Float.valueOf(latValues[i].trim()).floatValue();
}
latitude = Float.toString(sum / (float) latValues.length);