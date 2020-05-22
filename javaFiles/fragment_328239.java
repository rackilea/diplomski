for(BirdStatus birdStatus : birdStatusesToTake){
  if (birdStatus.getAge() == 10) {  
    System.out.println(birdStatus.getName()); 
    break;  //here you can use return birdStatus.getName();
  }
}