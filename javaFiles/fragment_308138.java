help.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("window closing");
                    test.print();
                }
            });