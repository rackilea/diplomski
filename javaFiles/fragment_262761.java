// You need an ArrayList to dynamically change the size of the array
// because you don't know exactly how many cars there will be total
ArrayList<Double> mpgList = new ArrayList<Double>();
for (int i = 0; i < familyMembers; i++){  
   int cars = // ...input dialog to ask how many cars each person has goes here
   for (int j = 0; j < cars; j++) {
      mpg = // user input
      mpgList.add(mpg)
   }
}

// to get total
int total = 0;
for (int i = 0; i < mpg.size();i++){
    total += mpgList.get(i);
}

// find average here