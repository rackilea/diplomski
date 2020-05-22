int typeNum; // This is what holds 1, 2, 3 etc for the type of ticket
             // 0 is used, so we'll just put a "NONE" as the string for it
String classType[] = {"NONE", "First Class", "Business", "Economy"};
...
System.out.println(name + 
                   "Your class type is: " + classType[typeNum] + 
                   "Your discount price is: " + discountPrice + 
                   "Your finalPrice is:" + finalPrice);