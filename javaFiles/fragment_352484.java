public void update(float valueX, float valueY , float valueZ) {
    float[] newData = new float[3];
    newData[0] = valueX;
    newData[1] = valueY;
    newData[2] = valueZ;
    dataset.advanceTime();
    dataset.appendData(newData);
}