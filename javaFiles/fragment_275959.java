red = (int) Math.random() * 256;
    green = (int) Math.random() * 256;
    blue = (int) Math.random() * 256;

    // this will show you what your values are
    // and key you in to where you should look:
    System.out.printf("Colors: [%d, %d, %d]%n", red, green, blue);

    Color endColour = new Color(red,green,blue);