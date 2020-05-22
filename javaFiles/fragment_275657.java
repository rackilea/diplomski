@Override
 public void run(int interfaceId, int componentId) {

 if (interfaceId == 382 && componentId == 19) {
    System.out.println("Am i printing?????");
    try {
    Thread.sleep(3000);
    } catch(InterruptedException e){
        e.printStackTrace();
    }
    WorldTasksManager.schedule(new WorldTask() {
        @Override
        public void run() {
            player.setNextWorldTile(toTile);
            player.faceObject(ditch);
            player.getControlerManager().startControler("Wilderness");
            player.resetReceivedDamage();
        }
    }, 2);

} else
    player.closeInterfaces();
end();

}