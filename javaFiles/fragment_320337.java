else if (e.getActionCommand().equals("Start"))
  {
    counter1Thread = new box1Thread();
    counter2Thread = new box2Thread();
    counter3Thread = new box3Thread();
    counter1Thread.start();
    counter2Thread.start();
    counter3Thread.start();

    toggleButton.setLabel("Stop");
    resultWindow.setText("");

  }