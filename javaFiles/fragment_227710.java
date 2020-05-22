String playerClass = input.nextLine();
Character player = null;

if (playerClass.equalsIgnoreCase("Warrior")){
    playerClass = "warrior";
    player = new Warrior();
}
if (playerClass.equalsIgnoreCase("Rouge")){
    playerClass = "rouge";
    player = new Rouge();
}