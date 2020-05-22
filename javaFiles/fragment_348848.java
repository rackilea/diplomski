final JTextField tf = new JTextField("click here ^");
        tf.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                try{
                    Rectangle rect = tf.modelToView(0);//for y value
                    System.out.println(tf.viewToModel(new Point(e.getX(), rect.y)));
                    int loc = tf.viewToModel(new Point(e.getX(), rect.y));
                    tf.setSelectionStart(loc);
                    tf.setSelectionEnd(loc);
                }catch(Exception ex){}//swallow the exception for demonstration only

            }
        });