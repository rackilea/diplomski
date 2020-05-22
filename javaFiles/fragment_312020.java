int c;
boolean found = false;

for(c = 0;c < MyArrayS.length;c++) {
  if(MyArrayS.compareTo(word) == 0) {
   found = true;
  }
}

if(!found) {
  System.out.println("Word does not exist");
}