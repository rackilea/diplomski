jlayer.jar 
      mp3plugin.jar
      jaudiotagger-2.0.1.jar

      private void playMe(){
        try{

         File file=new File("F:\\Net Beans Work Space\\mp3\\a.mp3");
         FileInputStream fis     = new FileInputStream(file);

             BufferedInputStream bis = new BufferedInputStream(fis);
             player = new Player(bis);

          int d=0;
           AudioFile audioFile = AudioFileIO.read(file);
           d = audioFile.getAudioHeader().getTrackLength();

           System.out.print("ddd=   "+d)  ;

             player.play();
      }catch(Exception e){

       System.out.print("ERROR "+e);
      }

     }