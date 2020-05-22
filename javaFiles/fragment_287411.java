Random rand = new Random();

float[][] myArray = new float[][]{
{ 600, rand.nextFloat() * 0.8f + 0.1f },
{ 900, rand.nextFloat() * 0.8f + 0.1f  },
{ 1200, rand.nextFloat() * 0.8f + 0.1f },
{ 1500,rand.nextFloat() * 0.8f + 0.1f  }
};


for (int i = 0; i < myArray.length; i++) {  
            for (int j = 0; j < myArray[i].length; j=j+2) {  
                float p1 = myArray[i][j]; 
                float p2 = myArray[i][j+1]; 
                System.out.println(p1+", " + p2);
            }  
        }