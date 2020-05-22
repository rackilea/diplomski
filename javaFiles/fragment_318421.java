int random = (int) (Math.random() * 49 + 1);
int random2 = (int) (Math.random() * 49 + 1);

//this can cause ArrayIndexOutOfBoundException, either change to above or 
//modify the dimension of your grid array
int random2 = (int) (Math.random() * 50 + 1);