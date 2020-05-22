public abstract class LazyAction implements Runnable { 

    public LazyAction(int millis) {
        Timer t = new Timer(millis, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                         try{
                            LazyAction.this.run();
                         catch(Exception e){
                            //Your error handling code
                         }
                        }

                    });
                    t.setRepeats(false);
                    t.start();
       }}