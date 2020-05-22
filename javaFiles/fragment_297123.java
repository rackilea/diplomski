Man maxAge = new Man(0);
for(Man man : list) {
  if(man.age > maxAge.age) {
    maxAge = man;
  }
}