if (eventSource == klantenbinding) {
    try {
        klantenbinding.MyFrame klantenbindingFrame = new klantenbinding.MyFrame();
        Component contentPane = klantenbindingFrame.getContentPane();
        mainWindow.add(contentPane);
        mainWindow.revalidate();
        mainWindow.repaint();
    } catch (ParseException e) {
      e.printStackTrace();  // never ignore exceptions
    }
}