public class RotateButtons extends JPanel {
  ...
  private boolean _firstClick = true;
  ...
  private void rotateButtons(CountButton source)
  {
    if (_firstClick) {
      _firstClick = false;
      boolean foundSource = false;
      for (int i = 0; i < _buttons.length; i++) {
        if (foundSource) {
          _currentColor = nextColor(_currentColor);
        } else {
          foundSource = _buttons[i] == source;
        }
      }
    }
    ...
  }

  private class CountButton extends JButton {
    ...

    public CountButton()
    {
      ...
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
          ...
          rotateButtons(CountButton.this);
        }
      });
    }
  }