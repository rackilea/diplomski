Scanner scan = new Scanner(System.in);
int count= scan.nextInt();
int lowest = Integer.MAX_VALUE;
boolean flag = false;
for(int i=0;i<count;i++) {
    int current = scan.nextInt();
    if(lowest<current) {
        flag = true;
        break;
    } else if(current<lowest) {
        lowest = current;
    }
}
if(flag) {
    System.out.println("false");
} else {
    System.out.println("true");
}