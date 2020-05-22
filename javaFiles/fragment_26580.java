class Selections{

    ArrayList<String> items = new ArrayList<String>();
    final ArrayList<String> combinationOne = new ArrayList<String>();
    final ArrayList<String> combinationTwo = new ArrayList<String>();
    final ArrayList<String> combinationThree = new ArrayList<String>();
    final ArrayList<String> combinationFour = new ArrayList<String>();

    JList list = null;
    public Selections(){
        items.add("11");
        items.add("21");
        items.add("31");
        items.add("41");
        items.add("12");
        items.add("22");
        items.add("32");
        items.add("42");

        list = new JList(items.toArray());

        combinationOne.add("11");
        combinationOne.add("12");
        combinationTwo.add("21");
        combinationTwo.add("22");
        combinationThree.add("31");
        combinationThree.add("32");
        combinationFour.add("41");
        combinationFour.add("42");
    }
    public static void main(String[] args) throws Exception {
        Selectionsselections = new Selections();
        selections.runApp();

    }

    private void runApp() {
    MouseMotionListener mouseMotionListener = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            JList eventList = (JList) e.getSource();
            addSelectionInterval(eventList);
        }
    };
        MouseListener mouseListener = new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JList eventList = (JList) mouseEvent.getSource();
                int index = eventList.locationToIndex(mouseEvent.getPoint());
                if (index >= -1) {
                    addSelectionInterval(eventList);
                }
            }
        };
        list.addMouseListener(mouseListener);
        list.addMouseMotionListener(mouseMotionListener );
        list.setCellRenderer(getRenderer());
        list.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // Set the default selection
        list.addSelectionInterval(0, 0);
        list.addSelectionInterval(4, 4);

        JOptionPane.showMessageDialog(null, new JScrollPane(list));
    }

    private void addSelectionInterval(JList eventList) {
        if (combinationOne.contains(eventList.getSelectedValue())) {
            eventList.addSelectionInterval(0, 0);
            eventList.addSelectionInterval(4, 4);
        } else if (combinationTwo.contains(eventList.getSelectedValue())) {
            eventList.addSelectionInterval(1, 1);
            eventList.addSelectionInterval(5, 5);
        } else if(combinationThree.contains(eventList.getSelectedValue())) {
            eventList.addSelectionInterval(2, 2);
            eventList.addSelectionInterval(6, 6);
        } else if (combinationFour.contains(eventList.getSelectedValue())) {
            eventList.addSelectionInterval(3, 3);
            eventList.addSelectionInterval(7, 7);
        }
    }

    private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createEmptyBorder());
                return listCellRendererComponent;
            }
        };
    }
}