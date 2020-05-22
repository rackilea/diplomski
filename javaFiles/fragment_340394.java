final Main f22 = new Main();
  initializer();
  f22.getfile(FileName, 0);
  f22.addPropertyChangeListener(new PropertyChangeListener() {
     @Override
     public void propertyChange(PropertyChangeEvent pcEvt) {
        if (pcEvt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
           // do your stuff here
        }
     }
  });
  f22.execute();