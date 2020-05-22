public int pop()
{
  if (top==0){
    System.out.println("Stack is empty");
 return -1;
}
 int temp = stack [top];
 top--;
 return temp;
}