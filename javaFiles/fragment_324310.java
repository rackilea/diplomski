...
int name=0;
while(true) {
    try {
        name = Integer.parseInt(scan.nextLine());
    }
    catch(Exception ex) {
        break;
    }
}