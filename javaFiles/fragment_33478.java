String[] listB = { "Some content on the right panel", "More content", "Some more content", "More and more content", "More and more content", "More and more content",
            "More and more content", "More and more content", "More and more content", "More and more content", "More and more content", "More and more content", "More and more content", "More and more content", 
            "More and more content" }; 


    final JList listBottom = new JList(listB);
    ....//other code
    listBottom.addMouseListener(new MouseAdapter(){

        //Called when you click the JList
        public void mouseClicked(MouseEvent e) {

            JList list = (JList)e.getSource();
            //Makes sure it only registers for single clicks(always registers even on double clicks, just registers twice.)
            if (e.getClickCount() == 1) {

                //Gets the point where you clicked and returns the index of the element at that point
                int index = list.locationToIndex(e.getPoint());
                //Makes sure that where you clicked was an element and that it is a String(We know it will be but its better to be safe)
                if(list.getModel().getElementAt(index) != null&&list.getModel().getElementAt(index) instanceof String){
                    //Populates your textField with the element at this index
                    textField.setText(list.getModel().getElementAt(index));
                }
            }
        }
    });