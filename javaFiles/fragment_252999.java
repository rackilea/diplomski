public Enemies(int choice){
    switch(choice)
    {
    case 1: 
        this.enemyName = "Sentient Shoelace";
        this.enemyHealth = 100.0;
        this.enemyAttackDamage = 1;
        this.enemyDefenseLevel = 1;
        this.hardLevel = 2;
        this.lootDropped = 100;
        break;
    case 2:
        this.enemyName = "Slimey Fartbox";
        this.enemyHealth = 100.0;
        this.enemyAttackDamage = 2;
        this.enemyDefenseLevel = 1;
        this.hardLevel = 3;
        this.lootDropped = 100;
        break;
    default: System.out.println("Mess up in the enemy selection process");
    }
}