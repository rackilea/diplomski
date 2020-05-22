JFrame frame = new JFrame();

    //Mock data
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    for (int i = 1; i < 5; i++) {
        DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Parent" + i);
        for (int j = 1; j < 5; j++) {
            parent.add(new DefaultMutableTreeNode("Child" + j));
        }
        root.add(parent);
    }

    DefaultTreeModel tmodel = new DefaultTreeModel(root);
    JTree tree = new JTree(tmodel);

    tree.setEditable(true);//To enable editing

    tree.getCellEditor().addCellEditorListener(new CellEditorListener() {

        @Override
        public void editingStopped(ChangeEvent e) {
            //add you code here
            System.out.println(((DefaultCellEditor) e.getSource()).getCellEditorValue());
        }

        @Override
        public void editingCanceled(ChangeEvent e) {
            //add you code here too
            System.out.println(((DefaultCellEditor) e.getSource()).getCellEditorValue());
        }
    });
    frame.add(new JScrollPane(tree));

    frame.setTitle("Tree Editor Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);