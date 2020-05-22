Creep[] creeps = new Creep[] 
    { R.drawable.creep_0, R.drawable.creep_1, R.drawable.creep_2, 
      R.drawable.creep_3 };
Object[] objectList = new Object[4];
for (int i = 0; i < 4; i++) {
    objectList[i] = new Object(name[i], description[i], creeps[i]);
}