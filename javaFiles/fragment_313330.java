public void rangedUpgrade(Ranged ranged) {       
        if (ranged.equals(WeaponList.getRanged("Shotgun"))){       
            this.ranged = ranged; 
            points = points + ranged.getWeaponPoints();
        } else 
            System.out.println("Can not have this weapon");
        }  
}