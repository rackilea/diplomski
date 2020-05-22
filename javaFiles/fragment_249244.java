public MyFrame (View v, Controller c) {

   // register listeners to view, e.g.
   v.addChangeListener(this /* or some other ui component */);

   // send events to controller, e.g.
   addActionListener(c /* or some interface that c provides */).

   // or even:
   deleteButton.addActionListener(new ActionListener(){
       @Override public void actionPerformed (ActionEvent e) {
           c.doDelete();
       }
   });   

}