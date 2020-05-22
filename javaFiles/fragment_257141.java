int boardWidth;
int boardHeight;
int boardSquareHeight;
int boardSqusreWidth;
JPanel north = new JPanel();
JPanel south = new JPanel();
Dimension northSouthD = new Dimension(boardWidth, boardSquareHeight);
north.setPreferedSize(northSouthD);
south.setPreferedSize(northSouthD);
JPanel east = new JPanel();
JPanel west = new JPanel();
Dimension eastWestD = new Dimension(boardSquareHeight, boardHeight - 2 * boardSquaareWidth);
east.setPreferedSize(easWestD);
west.setPreferedSize(easWestD);
// add all of the buttons to the appropriate JPanel
parentPanel.setLayoutManager(new BorderLayout());
parentPanel.add(north, BorderLayour.NORTH);
...