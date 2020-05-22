@Override
    public boolean equals(Object obj) {

        if (obj instanceof Zombie){

            Zombie zombiObj= (Zombie) obj;

            if(zombiObj.getName().equals(this.getName()) &&
                zombiObj.getInfection().equals(this.getInfection())&&
                zombiObj.getWeapon().equals(this.getWeapon()) &&
                zombiObj.getBrain()== this.getBrain() ) {

                return  true;
            }else{
                return false;

            }
        } else{

            return false;
        } 
    }