public class RotateButtons extends JPanel {
  private static final Color[] COLORS = { Color.ORANGE, Color.WHITE, Color.GREEN };
  private static final int BUTTON_COUNT = 3;
  private JButton[] _buttons;
  private int _currentColor = 0;

  public static void main(String[] args)
  {
    JFrame frame = new JFrame("JFrame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new RotateButtons());
    frame.setSize(500, 500);
    frame.setVisible(true);
  }

  public RotateButtons()
  {
    _buttons = new JButton[BUTTON_COUNT];
    for (int i = 0; i < _buttons.length; i++) {
      _buttons[i] = new CountButton();
      add(_buttons[i]);
    }
  }

  private void rotateButtons()
  {
    for (JButton button : _buttons) {
      button.setBackground(COLORS[_currentColor]);
      _currentColor = nextColor(_currentColor);
    }
    if (_buttons.length == COLORS.length) {
      _currentColor = nextColor(_currentColor);
    }
  }

  private int nextColor(int currentColor)
  {
    return (currentColor + 1) % COLORS.length;
  }

  private class CountButton extends JButton {
    private int _count = 0;

    public CountButton()
    {
      setBackground(Color.YELLOW);
      setText("Pick ME");
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
          _count++;
          setText("# of clicks = " + _count);
          rotateButtons();
        }
      });
    }
  }
}