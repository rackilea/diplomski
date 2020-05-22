public static void main(String args[]) throws IOException {

    final DefaultGraph g = new DefaultGraph("my beautiful graph");
    g.setStrict(false);
    Viewer viewer = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
    JFrame myJFrame = new JFrame();
    myJFrame.setPreferredSize(new Dimension(600, 600));
    DefaultView view = (DefaultView) viewer.addDefaultView(false);   // false indicates "no JFrame".
    view.setPreferredSize(new Dimension(400, 400));
    myJFrame.setLayout(new FlowLayout());
    myJFrame.add(view);
    JButton myButton = new JButton("MyButton");
    myButton.addActionListener(e -> System.out.println("Somebody pushed my button."));
    myJFrame.add(myButton);
    JSlider slider = new JSlider();
    slider.addChangeListener(e -> view.getCamera().setViewPercent(slider.getValue() / 10.0));
    myJFrame.add(slider);
    myJFrame.pack();
    myJFrame.setVisible(true);
    myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    viewer.enableAutoLayout();
    ViewerPipe vp = viewer.newViewerPipe();
    vp.addViewerListener(new ViewerListener() {
        @Override
        public void viewClosed(String viewName) {
            // dont care
        }

        @Override
        public void buttonPushed(String id) {
            Node n = g.getNode(id);
            String attributes[] = n.getAttributeKeySet().toArray(new String[n.getAttributeKeySet().size()]);

            String attributeToChange = (String) JOptionPane.showInputDialog(null, "Select attibute to modify", "Attribute for " + id, JOptionPane.QUESTION_MESSAGE, null, attributes, attributes[0]);
            String curValue = n.getAttribute(attributeToChange);
            String newValue
                    = JOptionPane.showInputDialog("New Value", curValue);
            n.setAttribute(attributeToChange, newValue);
        }

        @Override
        public void buttonReleased(String id) {
            // don't care
        }
    });
    g.addNode("A");
    g.addNode("B");
    g.addNode("C");

    g.addNode("E");
    g.addNode("F");
    g.addNode("G");

    g.addNode("1");
    g.addNode("2");
    g.addNode("3");

    g.addNode("4");
    g.addNode("5");
    g.addNode("6");

    g.addEdge("AB", "A", "B");
    g.addEdge("AC", "B", "C");
    g.addEdge("BC", "C", "C");

    g.addEdge("EB", "E", "B");
    g.addEdge("FC", "F", "C");
    g.addEdge("GC", "G", "C");

    g.addEdge("1B", "1", "B");
    g.addEdge("2C", "2", "C");
    g.addEdge("3C", "3", "C");

    g.addEdge("4B", "4", "B");
    g.addEdge("5C", "5", "C");
    g.addEdge("6C", "6", "C");

    g.getNode("A").setAttribute("size", "big");
    g.getNode("B").setAttribute("size", "medium");
    g.getNode("C").setAttribute("size", "small");
    g.getNode("A").setAttribute("ui:color", "red");
    g.getNode("B").setAttribute("ui:color", "blue");
    g.getNode("C").setAttribute("ui:color", "green");

    for (Node node : g) {
        node.addAttribute("ui.label", node.getId());
    }
    while (true) {
        (view).repaint();
        vp.pump();
    }
}