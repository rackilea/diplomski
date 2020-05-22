JMenu menu = new JMenu("Ports");
    LoadPortsWorker worker = new LoadPortsWorker();
    worker.addPropertyChangeListener(new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        LoadPortsWorker worker = (LoadPortsWorker)evt.getSource();
        switch (evt.getPropertyName()) {
          case "state":
            switch (worker.getState()) {
              case DONE:
                try {
                  List<CommPortIdentifier> ports = worker.get();
                  ButtonGroup bg = new ButtonGroup();
                  for (CommPortIdentifier port : ports) {
                    JRadioButtonMenuItem mi = new JRadioButtonMenuItem(new PortAction(port));
                    bg.add(mi);
                    menu.add(mi);
                  }
                } catch (InterruptedException | ExecutionException exp) {
                  exp.printStackTrace();
                }
                break;
            }
        }
      }
    });
    worker.execute();

    JMenuBar mb = new JMenuBar();
    mb.add(menu);

    JFrame frame = new JFrame("Testing");
    frame.setJMenuBar(mb);