if (format.getEncoding().equals(new AudioFormat.Encoding("VORBISENC"))) {
            byte [] buffer = new byte[4096];
            int n;
            FileOutputStream fos = new FileOutputStream(outputFile + ".pcm");    
            while(-1 != (n = din.read(buffer))) {
                fos.write(buffer, 0, n); 
            }    
            fos.close();

            AudioInputStream pcmIn = new AudioInputStream(new FileInputStream(outputFile + ".pcm"), targetFormat, frames);
            AudioSystem.write(pcmIn, AudioFileFormat.Type.WAVE, new FileOutputStream(outputFile));
            File f = new File(outputFile + ".pcm");
            f.delete();
        } else {
            AudioInputStream shortenedStream = new AudioInputStream(din, targetFormat, frames);
            AudioSystem.write(shortenedStream, new AudioFileFormat.Type("WAVE", "wav"), outputFile);
        }