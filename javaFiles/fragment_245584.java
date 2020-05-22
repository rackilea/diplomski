public GUI() {
    this.setTitle("Tree");
    this.setSize(900, 700);
    this.setLocation(300, 100);
    this.setResizable(false);
    setBackground(Color.red);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cp = (JPanel) this.getContentPane();
    //REMOVE null layout.
    //cp.setLayout(null);
    cp.setBackground(Color.WHITE);

    Node a = new Node("+");
    Node b = new Node("3");
    Node c = new Node("x");

    a.left = b;
    a.right = c;

    tree = new Node[3];
    tree[0] = a;
    tree[1] = b;
    tree[2] = c;

    System.out.print(tree[0].data);
    System.out.print(tree[0].left.data);
    System.out.print(tree[0].right.data);

    // No useless repaints/revalidates
    //Add the tree to the content pane
    cp.add(dtree);


    System.out.print("a");
}