//loops through first dimension
for(int row=0;row<myList.size();row++) {
    //check that T/F you mentioned
    if(myBoolean) {
        //loop through second dimension
        for(int i=0;i<myList.get(row).size();i++) {
            //subtract 1 from everything in second dimension
            myList.get(row).set(i, myList.get(row).get(i)-1);
        }
    }
}