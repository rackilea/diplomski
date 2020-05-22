btn[4].addActionListener(new ActionListener(){
       String str;
       public void actionPerformed(ActionEvent e) {
           if (tree.size() != 0){
               if ((str)==null){
                   str = tree.firstKey();
                   } else {
                   fldFio.setText(str);
                   fldNumber.setText(tree.get(str));
                   str = tree.higherKey(str);   
                   }
          }
       }
   });