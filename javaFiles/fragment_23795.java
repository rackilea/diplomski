File x = new File("D:\\player.txt");
try {
    e = new Scanner(x);
    while (e.hasNext()){

     playername = e.next();
     if(e.hasNext()){
     playerlevel = e.next();
     }

     if(e.hasNext()){
     playerstrenght = e.next();
      }
     if(e.hasNext()){
        playerdefense = e.next();
      }
      if(e.hasNext()){
        playersoul = e.next();
      }

}