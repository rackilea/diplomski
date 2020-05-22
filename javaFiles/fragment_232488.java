TableColumnModel columnModelCompareL = table_CompareL.getColumnModel();
     ArrayList<Float> statsCompareL=new ArrayList<Float>();
     columnModelCompareL.addColumnModelListener(new TableColumnModelListener() {
         // implementation left out for brevity
     });

     // this runs during construction time, long before statsCompareL is updated
     System.out.println("statsCompareL"+statsCompareL);

     JButton testButton = new JButton("Test ArrayList");
     testButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // this runs after the button is clicked, so it will see the changes statsCompareL
             System.out.println("statsCompareL"+statsCompareL);
         }
     });
     // add the button somewhere convenient for testing purposes