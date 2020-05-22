// Read from same package 
list.add(resizeImage(ImageIO.read(getClass().getResourceAsStream("c.png"))));

// Read from absolute path
list.add(resizeImage(ImageIO.read(new File("E:\\SOFTWARE\\TrainPIS\\res\\drawable\\c.png"))));

// Read from images folder parallel to src in your project
list.add(resizeImage(ImageIO.read(new File("images\\c.jpg"))));