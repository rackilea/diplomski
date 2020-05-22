int typeNum; // Still the int that should be either 1, 2, or 3 for type of ticket
...

String classType;

if ( typeNum == 1 ) {
    classType = "First Class";
} else if ( typeNum == 2 ) {
    classType = "Business";
} else if ( typeNum == 3 ) {
    classType = "Economy";
} else {
    classType = "(Unrecognized Ticket Type)";
}

System.out.println(name + 
                   "Your class type is: " + classType + 
                   "Your discount price is: " + discountPrice + 
                   "Your finalPrice is:" + finalPrice);