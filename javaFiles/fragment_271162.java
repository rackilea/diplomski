new Thread() {

  @Override
  public void run() {
    //As your stream implements Closeable, it is better to use a "try-with-resources"
    try(FileInputStream fis = new FileInputStream("C:/Users/Admin/Music/B.B. King - Blues Boys Tune - YouTube.mp3")){
      new Player(fis).play();
    }catch(Exception e){System.out.println(e);}
  }
}.start();