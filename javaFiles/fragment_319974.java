List list = something.b.c.d.getList();
for(Object obj : list){
   if (list.contains(...)) { // inefficient, used purely as an illustration
      ...
   }
}
int n = list.size();