File file=new File("path/to/file");
    byte[] bytes= Files.readAllBytes(file.toPath());
    //edit or trim bytes as you wish.
    ByteArrayInputStream inputStream=new ByteArrayInputStream(bytes);//you can even give an offset in this constructor
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);

    clip.start();
    Thread.sleep(xAmount);