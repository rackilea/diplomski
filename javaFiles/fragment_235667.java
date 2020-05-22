BufferedImage imo;
        try {
            imo = ImageIO.read(new File("location_of_file"));
            System.out.println(imo.getHeight());
            System.out.println(imo.getWidth());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }