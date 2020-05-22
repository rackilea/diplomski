Queue<String> myQ=new LinkedList<>();
    int count=0;
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {                                      

    myQ.add(++count+":" + Username.getText());//add into queue
    mylist.setText("");//use to insert new data
    mylist.append(myQ +"\n");//insert queue object into text area
    myQ.peek();//get top value of queue


    }