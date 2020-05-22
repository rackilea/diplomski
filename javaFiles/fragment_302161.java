public void update( final WeirdNode node, final long nextSuperCrazyNumber ) {
    SwingUtilities.invokeLater( new Runnable() {
        public void run() {
            node.superCrazyNumber = nextSuperCrazyNumber;
            ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
        }
    });
}

public static void main(String[] args) {
    WeirdTreeFrame frame = new WeirdTreeFrame();
    Random rnd = new Random(41);

    for (long i = 0; ; i++) {
        for (WeirdNode node = frame.root; node != null; node  =(WeirdNode)node.getChildAt(rnd.nextInt(3))) {
            long superCrazyNumber = node.superCrazyNumber;
            frame.update( node, superCrazyNumber++ );
        }
    }
}