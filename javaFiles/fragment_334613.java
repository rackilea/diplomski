private void findIntersection(final ArrayList<Segment> segments) {
  final SwingWorker<Void, Double> myWorker = new SwingWorker<Void, Double>() {

     @Override
     protected Void doInBackground() throws Exception {
        QTree Q = new QTree();
        for (Segment s : segments) {
           Q.initialise(s);
        }
        TreeT T = new TreeT();
        while (Q.getRoot() != null) {
           Point p = Q.maxEventPoint(Q.getRoot());
           Q.delete(p.getX(), p.getY());
           publish(p.getY()); // push data to process method

           // take care that this method below does not
           // make Swing calls
           handleEventPoint(p, T, Q);
        }
        return null;
     }

     @Override
     protected void process(List<Double> chunks) {
        for (Double yValue : chunks) {
           // this is called on the EDT (Swing event dispatch thread)
           mapPanel.setSweeplinePosition(yValue);
           mapPanel.repaint();
        }
     }
  };
  myWorker.addPropertyChangeListener(new PropertyChangeListener() {

     @Override
     public void propertyChange(PropertyChangeEvent evt) {
        // get notified when Worker is done
        if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
           // TODO: any clean up code for when worker is done goes here
           try {
              myWorker.get(); // must call to trap exceptions that occur inside worker
           } catch (InterruptedException e) {
              e.printStackTrace();
           } catch (ExecutionException e) {
              e.printStackTrace();
           }
        }
     }
  });
  myWorker.execute(); // execute worker
}