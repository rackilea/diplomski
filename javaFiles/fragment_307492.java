Scanner b = new Scanner(System.in);
double lage;

while (true) {
    System.out.println("2 - Set The Age");
    if(b.hasNextDouble()){
        lage = b.nextDouble();
        break;
    }else b.nextLine();
}