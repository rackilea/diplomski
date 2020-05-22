CheckBox[] boxes = new CheckBox[5];
int[] ids = new int[]{R.id.checkOne, R.id.checkTwo, R.id.checkThree, 
                      R.id.checkFour, R.id.checkFive};

for (int i=0; i<5; i++) {
   boxes[i] = (CheckBox) findViewById(ids[i])
}