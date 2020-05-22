public JOptionPane()
JOptionPane optionPane = new JOptionPane();

public JOptionPane(Object message)
JOptionPane optionPane = new JOptionPane("Message");

public JOptionPane(Object message, int messageType)
JOptionPane optionPane = new JOptionPane("Message",  JOptionPane.WARNING_MESSAGE);

public JOptionPane(Object message, int messageType, int optionType)
JOptionPane optionPane = new JOptionPane("Question?",  JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);

public JOptionPane(Object message, int messageType, int optionType,  Icon icon)
Icon printerIcon = new ImageIcon("yourFile.gif");
JOptionPane optionPane = new JOptionPane("Question?",  JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, printerIcon);

public JOptionPane(Object message, int messageType, int optionType, Icon icon,  Object options[ ])
Icon greenIcon = new DiamondIcon(Color.GREEN);
Icon redIcon = new DiamondIcon(Color.RED);
Object optionArray[] = new Object[] { greenIcon, redIcon} ;
JOptionPane optionPane = new JOptionPane("Question?",  JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, printerIcon,  optionArray);

public JOptionPane(Object message, int messageType, int optionType, Icon icon, Object options[], Object initialValue)
JOptionPane optionPane = new JOptionPane("Question?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, printerIcon, optionArray, redIcon