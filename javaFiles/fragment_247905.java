int numOfLines; //stores num of lines that will be inputted
Scanner reader = new Scanner(System.in);  //assuming you already imported before this

numOfLines = reader.nextInt(); //captures 1st user inputted value

int[] nums = new int[numOfLines];  //creates array object to captures all further values

for (int i = 0;i<numOfLines-1;i++){
nums[i] = reader.nextInt();  //captures values and stores in Array nums
}