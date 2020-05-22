String entered;
while(true) {
    entered = input.nextLine();
    if(entered.equalsIgnoreCase("exit")) break;
    for(int i = 0; i < nameArray.length; i++) {
        if(entered.equals(nameArray[i])) {
            System.out.println("Name: " + nameArray[i] + "\tTime: " + resultArray[i]);
        }
    }
}