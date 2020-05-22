final SwingWorker<Object,Object> worker2 = new SwingWorker<Object, Object>() {
        public Object doInBackground() throws Exception {
          boolean one_write_only = true;
            while(!in.ready()){ /* C*/ 
              if(one_write_only){
                System.out.println("waiting server");
                one_write_only = false;
              }
            }
            return one_write_only;
        }

        protected void done() {
            try {
                block.setVisible(false);
            } catch (Exception ignore) {}
        }

};
worker2.execute();
block.setVisible(true);