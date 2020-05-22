int tmp = i; // volatile load
 // [LoadStore|LoadLoad]

 // see how they have been inverted here...
 int y = 4; // plain store
 int x = 3; // plain store