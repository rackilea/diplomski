Random generator = new Random();
for(int i = 0; i < 100; i++){
  int j = generator.nextInt(4); // this will give us 0,1,2,or 3
  arraylist.add(objects[j]);
  // etc.. continues with 3 other else if statments and objects
}