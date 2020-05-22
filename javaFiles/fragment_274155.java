IOStreamConnector input = new IOStreamConnector();
      IOStreamConnector error = new IOStreamConnector();
      input.setCloseInput(false);
      error.setCloseOutput(false);
      input.connect(System.in, session.getOutputStream());
      error.connect(session.getStderrInputStream(), System.out);

      InputStream in = session.getInputStream();
      TerminalEmulation emulation = new TerminalEmulation("vt320");
      emulation.setRecordPrintableOnly(true);
      emulation.startRecording(System.out);
      byte[] buf = new byte[1024];
      int r;
      while ((r = in.read(buf)) != -1) {
          emulation.putBytes(buf, 0, r);
      }