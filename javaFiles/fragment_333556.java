thisApplet.setCursor(new Cursor(Cursor.WAIT_CURSOR));
  selectdocumentTreeLeaf(); 
  tree.repaint();
  thisApplet.repaint();
  tree.setEnabled(false); 

  new SwingWorker<Image, Void>(){
     @Override
     protected Image doInBackground() throws Exception {
        return createImage(queue.q[pointer].currentPage);;
     }

     @Override
     protected void done() {
        try {
           result = get();
           thisApplet.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
           tree.setEnabled(true);
        } catch (InterruptedException e) {
           e.printStackTrace();
        } catch (ExecutionException e) {
           e.printStackTrace();
        }
     }
  }.execute();