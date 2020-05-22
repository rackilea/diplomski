if (firstenemyattack > firstdefense) { 
    int firstenemyhitpointattack = (int) Math.ceil(Math.random() 
            * firstenemyhitpoints);
    // Presumably, firstbattlehealth -= firstenemyhitpointattack here?
    System.out.println("The enemy did " + firstenemyhitpointattack 
            + " damage to you. You have " + firstbattlehealth 
            + " health remaining.");
} else { // <-- An "else" block, firstenemyattack <= firstdefense
    System.out.println("Enemy attack missed!");
}