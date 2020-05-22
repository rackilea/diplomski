public class Player {
    private Set<Equipment> mountedEquipment;
    private Stats baseStats;

    public Player(Stats baseStats) {
       this.baseStats = baseStats;//set base stats for player
       mountedEquipment = new HashSet<Equipment>();
    }

    public void mountEquipment(Equipment equipment) { 
          baseStats.setMagic(baseStats.getMagic()+equipment.getStats().getMagic());

         //update base stats similarly for strength, hitpoints, etc
         mountedEquipment.add(equipment);

    }

    public void unmountEquipment(Equipment equipment) {

       baseStats.setMagic(baseStats.getMagic()-equipment.getStats().getMagic());
       //update base stats in a similar fashion for strength, hitpoints, etc
       mountedEquipment.remove(equipment);
    }

    public Set<Equipment> getMountedEquiptment() {
        return Collections.unmodifiableSet(mountedEquiptment);
    }

}