public class W221 {
  public static void main(String[] args) {
  while (JPL.test()) {
  Scanner kb = new Scanner (System.in);
  int num = kb.nextInt();
  int num2 = kb.nextInt();
  int value1;
  int value2;

  if(num <= 15 || num2 <= 15){
    value1 = 15 - num;
    value2 = 15 - num2;

    if(value1 < 0){
      value1 = 50;
    }
    if(value2 < 0){
      value2 = 50;
    }
    if(value1>value2){
        System.out.println(" " + num2);
    }
    else if(value1<value2){
        System.out.println(" " + num);
    }
  }
  else{
    System.out.println(0);
  }}}}