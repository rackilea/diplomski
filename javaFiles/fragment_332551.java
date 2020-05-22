Scanner fInput = null; //This change is important!
try {
    fInput = new Scanner(new File("accountData.txt"));
}
catch(Exception e) {
    System.out.println("ERROR: File Not Found.");
}
if(fInput!=null) {
    while(fInput.hasNext()) {
        String tempID = fInput.next();
        String tempFName = fInput.next();
        String tempLName = fInput.next();
        String tempPNumber = fInput.next();
        String tempEmail = fInput.next();
        System.out.println(tempID+""+tempFName+""+tempLName+""+tempPNumber+""+tempEmail);
    }
}