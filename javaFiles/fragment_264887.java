for(Passenger a : p){
    if(a.getBill() != 0.0){ // the if to check the value of bill
        printStream.print(a.getCardNumaber() + " ");
        printStream.println(a.getBill());
    }
}

for(Passenger a : p){
    double dBill = Double.parseDouble(a.getBill()); // in case getBill() returns a String
    if(dBill != 0.0){ // the if to check the value of bill
        printStream.print(a.getCardNumaber() + " ");
        printStream.println(a.getBill());
    }
}