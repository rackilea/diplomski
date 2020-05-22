ArrayList<String> listOfPattern=new ArrayList<String>();

String ptVisa = "^4[0-9]{6,}$";
listOfPattern.add(ptVisa);
String ptMasterCard = "^5[1-5][0-9]{5,}$";
listOfPattern.add(ptMasterCard);
String ptAmeExp = "^3[47][0-9]{5,}$";
listOfPattern.add(ptAmeExp);
String ptDinClb = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$";
listOfPattern.add(ptDinClb);
String ptDiscover = "^6(?:011|5[0-9]{2})[0-9]{3,}$";
listOfPattern.add(ptDiscover);
String ptJcb = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$";
listOfPattern.add(ptJcb);
}