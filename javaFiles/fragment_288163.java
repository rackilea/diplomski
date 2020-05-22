public void attack(Player somePlayer) {

    somePlayer.totalHealth = somePlayer.totalHealth - this.damage;
    if (somePlayer.totalHealth.equals(0) || somePlayer.totalHealth < 0) {
        System.out.println("Your player died");
    } else {
        System.out.println("The monster attacked " + somePlayer.getName() + " and made " + this.damage + " damage");
        System.out.println("Your remaining health is - " + (somePlayer.totalHealth - somePlayer.getStrength()));
    }

}