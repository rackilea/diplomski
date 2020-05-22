if (userIn2.hasNextInt()){
  // process integer
  obj = userIn2.nextInt();
} else if(userIn2.hasNextDouble()) {
  // process double
  obj = userIn2.nextDouble();
} else {
  // process String
  obj = userIn2.next();
}