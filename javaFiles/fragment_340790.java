Iterator iterFieldValues=listOfFields.iterator();
for (int i=0;i<noOfRows;i++){
    String fieldName=(String)iterFieldValues.next();
    String minLength=(String)iterFieldValues.next();
    String maxLength=(String)iterFieldValues.next();
    String fieldType=(String)iterFieldValues.next();
    ...
}