while(p.getPlayer().isComplete() == false){
String bOutput = "Duration ::" + (int) ((p.getPlayer().getPosition() / (1000*60)) % 60) + " : " + (int) (p.getPlayer().getPosition() / 1000) % 60;
System.out.println(bOutput+"\r");

Thread.sleep(1000);
}