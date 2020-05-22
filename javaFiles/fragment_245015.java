for (int i = 0; i < fallen_tetros.size(); i++) {
   println("i: " + i);     
   if (fallen_tetros.get(i)[1] == h) {
     println("removing: " + i);
     fallen_tetros.remove(i);
     println("tetros size: " + tetros.size());
   }
}