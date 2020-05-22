System.out.println("Enter 5 temperature readings");
Scanner input = new Scanner(System.in);



int count = 1;
int low = input.nextInt(); //the lowest value cannot possible be higher than this.
while (count <= 4){ //made the loop shorter because one value was already read.
  int temp = input.nextInt();
  if (temp < low){
    low = temp;
  }

  count++;

}
System.out.println(low);