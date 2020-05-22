if (eventSource == klantenbinding) {
    try {
        klantenbinding.MyFrame klantenbindingFrame = new klantenbinding.MyFrame();
        // mainWindow.add(klantenbindingFrame);
        klantenbindingFrame.setVisible(true);
    } catch (ParseException e) {
      e.printStackTrace();  // never ignore exceptions
    }
}