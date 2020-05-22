boolean correctAspectRatio = ...; // check to see if new size meets aspect ratio requirements

if (!correctAspectRatio) {
  final Frame _frame = this;
  final int _width = ...; // calculated width
  final int _height = ...; // calculated height

  SwingUtilities.invokeLater(new Runnable(){
    public void run() {
      _frame.setSize(_width, _height);
    }
  });
}