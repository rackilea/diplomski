Scanner scan=new Scanner(System.in);
String input=scan.readLine();
String[] nums=input.split();
int[] numbers=nums.length;
for(int i=0;i<nums.length;i++){
    numbers[i]=Integer.parseInt(nums[i]);
}