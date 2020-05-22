setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               int a = JOptionPane.showConfirmDialog(null, 
                            "Are you sure you want to exit the program?", "Exit Program ",
                            JOptionPane.YES_NO_OPTION);
               System.out.println(a);
               if(a==JOptionPane.OK_OPTION){
                   dispose();//You can use System.exit(0) if you want to exit the JVM
               }
           }});