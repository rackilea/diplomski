public enum EnemyType { 

    WEAK_SKELETON("Weak Skeleton"), BLUE_SLIME("Blue Slime"), NVC_ROGUE_MAGE("Novice Rogue Mage"); 

    private String name; 

    public String getName() { 
        return this.name; 
    }

    private EnemyType (String name) {
        this.name = name;
    } 
}