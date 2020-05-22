System.out.println("Please enter the first number you wish to calculate.");
boolean ok = false;
while (!ok){
    try {
        a = in.nextInt();
        ok = true;
    } catch (Exception e){
        System.out.println("Invalid number.");
    }
}