Random rnd = new Random();
int r = rnd.nextInt(128) + 128; // 128 ... 255
int g = rnd.nextInt(128) + 128; // 128 ... 255
int b = rnd.nextInt(128) + 128; // 128 ... 255

Color clr = Color.rgb(r, g, b);