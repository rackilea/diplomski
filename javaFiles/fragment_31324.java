FTAWeapon weapon = null; // Declaration outside the switch statement
switch(kb.next())
{
          case "1":
             System.out.println("\n\n*.44 Magnum Revolver added to inventory*");
             weapon = new FTAWeapon(1, 6, 1, 5, 8, .75);
             break;

          case "2":
             System.out.println("\n\n*Assault Rifle added to inventory*");
             weapon = new FTAWeapon(2, 24, 3, 7, 15, .65);
             break;

          case "3":
             System.out.println("\n\n*Laser Pistol added to inventory*");
             weapon = new FTAWeapon(3, 30, 1, 2, 6, .85);
             break;

          case "4":
             System.out.println("\n\n*Caravan Shotgun added to inventory*");
             weapon = new FTAWeapon(4, 14, 7, 3, 20, .50);
             break;

          case "5":
             System.out.println("\n\n*Plasma Rifle added to inventory*");
             weapon = new FTAWeapon(5, 24, 1, 5, 10, .70);
             break;
}