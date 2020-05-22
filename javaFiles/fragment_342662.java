if (first.contains("a") || first.contains("A")) {
  System.out.print("How many to remove from pile " + first + "? ");
  int second = input.nextInt();
  input.nextLine(); // firing an blank nextLine call
  count = count + 1;
  a = a - second;
  System.out.println("A: " + a + " B: " + b + " C: " + c);

  if(a <= 0 && b <= 0 && c <= 0){
     break nim_loop;
  }