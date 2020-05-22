boolean equal = set1.size() == set2.size();
if(equal) {
  for(Object x: set1) {
    if(!set2.contains(x)) {
      equal = false;
      break;
    }
  }
} 
System.out.println(equal);