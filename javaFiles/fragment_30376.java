List<String> spawned = new ArrayList<String>();

private Location spawnPlayer(Player p){
   int r = new Random().nextInt(ServerManager.getInstance().getServer(p).getSpawns().size());
   final Spawn s = ServerManager.getInstance().getServer(p).getSpawns().get(r);

   if(s.hasPlayer() && !spawned.contains(p.getName()){
      spawned.add(p.getName());
      spawnPlayer(p);
   }
   else{
     //the rest of your code...
   }
}