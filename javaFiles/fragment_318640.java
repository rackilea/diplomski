//it is better to return the List instead of declaring it as a static field
public List<Test> Base_Seperator() {
    //try to declare variables in the narrower scope
    //String temp, temp2;
    //String[] split;
    //String days, events;

    //this variable must be recognized in all the paths of this method
    List<Test> testList = new ArrayList<Test>();
    for(int i = 0; i < baseArrayList.size(); i++) {
        //these variables should only work within the for statement
        String temp = baseArrayList.get(i).events;
        String temp2 = baseArrayList.get(i).days;
        String[] split = temp.split(":");
        //you have splitted the String by :
        //now you have every element between : as an item stored in split array
        //go through each one and create a new Test instance
        //first, let's create the lineNumber variable as String
        String lineNumber = Integer.toString(i+1);
        //using enhanced for to go through these elements
        for (String value : split) {
            //now, let's create Test instance
            Test test = new Test(value, lineNumber);
            //store the instance in testList
            testList.add(test);
        }
    }
    //now just return the list with the desired values
    return testList;
}