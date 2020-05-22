File f = new File("your audio file.wav");
FileInputStream fis = new FileInputStream(f);
AudioInputStream ais = AudioSystem.getAudioInputStream(f);

// prints the number of bytes that are detected not to be audio data
System.out.println(fis.available() - ais.available());