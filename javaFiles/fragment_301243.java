ClassLoader classLoader = getClass().getClassLoader();

        try {
                InputStream in = classLoader.getResourceAsStream("/assets/baseline_close_black_18dp.png");
                Image image = new Image(in);
                ImageView imageView= new ImageView(image);

            } catch (Exception ex) {

            }