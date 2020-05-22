JsonArray coords = jsonObject.getJsonArray("coords");

int count = coords.size();
double[] uvw = new double[count];
for (int i = 0; i < count; i++) {
    uvw[i] = coords.getJsonNumber(i).doubleValue();
}