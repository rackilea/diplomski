String[] seperated = jTextField1.getText().split("\\.");
    int[] intseperated = new int[2];
    intseperated[0] = Integer.parseInt(seperated[0]);
    intseperated[1] = Integer.parseInt(seperated[1]);
    int price1 = intseperated[0] * propertiesFile.multiply_water;
    double price2 = (intseperated[1] * propertiesFile.multiply_water) / 60.0D;
    double price = (price1 + price2);