if (arg0._time > arg1._time){
   return -1
} else if (arg0._time < arg1._time){
   return 1;
} else {
   return arg0._title.compareTo(arg1._title);
}