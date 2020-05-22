List <House> houseL = new ArrayList();
 houseL.add(house1);
 houseL.add(house2);
 houseL.add(house3);
 System.out.println("-- Directions --");
 for (House house:houseL){
    System.out.println(house.getDirection());
 }
 System.out.println("-- Zip Codes--");
 for (House house:houseL){
    System.out.println(house.getPostCode());
 }
//etc