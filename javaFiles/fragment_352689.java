submit.addActionListener(
            new ActionListener(){
                //x should be a field since its accessed within other methods
                public Formatter x;

                //this method should be public
                public void actionPerformed(ActionEvent event){

                }

                //open file should be a different method and remove it from actionPerformed
                private void openFile(){
                    try{
                        x = new Formatter("D:\\gta.txt");
                    }
                    catch(Exception e){
                        System.out.println("You got an error");
                    }


                }

                public void addRecords(){
                    x.submit();
                }
                public void closeFile(){
                    x.close();
                }
            }

            );