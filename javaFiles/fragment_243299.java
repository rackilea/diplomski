public class LoadPortsWorker extends SwingWorker<List<CommPortIdentifier>, Object> {

    @Override
    protected List<CommPortIdentifier> doInBackground() throws Exception {
      return Ports.listCommPorts();
    }

  }