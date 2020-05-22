int INITIAL_X_SIZE = 100;
int INITIAL_Y_SIZE = 100;
int INITIAL_Z_SIZE = 100;
ArrayList<ArrayList<ArrayList<String>>> arrSup = new ArrayList<ArrayList<ArrayList<String>>>(INITIAL_X_SIZE);

// Initialize the ArrayLists:
for(int x = 0; x < INITIAL_X_SIZE; x++) {
  arrSup.set(x, new ArrayList<ArrayList<String>>(INITIAL_Y_SIZE));
  for(int y = 0;y < INITIAL_Y_SIZE; y++) {
    arrSup.get(x).set(x, new ArrayList<String>(INITIAL_Z_SIZE));
  }
}

// Iterate through it and do whatever you want to do:
for(int x = 0; x < arrSup.size(); x++) {
  for(int y = 0; y < arrSup.get(x).size(); y++) {
    for(int z = 0; z<arrSup.get(x).get(y).size(); z++) {
       array.get(x).get(y).set(z, "Lorem ipsum");
    }
  } 
}