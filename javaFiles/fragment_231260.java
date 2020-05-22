class FatZombieComparator implements Comparator<Zombie>{

     int compare(Zombie z1, Zombie z2){
       return z1.getFat() - z1.getFat();
     }
 }