String name = Username.getText(); //get text from text field
String name2 = mylist.getText();//get text from text area
mylist.setText(""); //remove all text in text area
Queue<String> myQ=new LinkedList<String>();

    myQ.add(name2);//add already writen data in text area
    myQ.add(name);//add text field data

    for(String str : myQ){ //iterate
        //System.out.print(str +" ");
        mylist.append(str +" ");//append into text area

    }