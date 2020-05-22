public void rangedUpgrade(Ranged ranged) 
        {    
            switch(ranged.toString())
            {
                case "Heavy Bolter" : 
                case "Missle Launcher" :            
                  if (getSquad().checkUses(ranged.toString())) {
                    System.out.println(
                    "This scout's squad is already using a " + ranged);
                    break;
                  }
                case "Bolter" : 
                case "Shotgun" :
                case "Sniper Rifle" : 
                    this.ranged = ranged; 
                    points = points + ranged.getWeaponPoints();
                break;        
                default :
                    System.out.println("A Scout can't have a " + ranged);                   
                break;
            }
        }