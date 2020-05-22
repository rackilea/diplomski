public void play(String file) throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {

    try 
        {   
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(file));
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }

    catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1)
        {
            e1.printStackTrace();
        }
    }