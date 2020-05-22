FileInputStream mp3_file=new FileInputStream("xyz.mp3");
Player mp3=new Player(mp3_file);
 for(int i=0;i<=3; i++)
     mp3.play();

System.out.println("Over");