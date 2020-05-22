public class Test5 implements MouseListener {

    private JDesktopPane pane;
    public int mouseCount;

    public static void main(String[] args) {
        new Test5();
    }

    private int xpos = 0;
    private int ypos = 0;

    public Test5() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                pane = new Test5.DesktopPane() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 400);
                    }

                };
                pane.add(newInternalFrame(), 10);
                pane.add(newInternalFrame(), 10);
                pane.add(newInternalFrame(), 10);

                JFrame frame = new JFrame();
                frame.add(pane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public JInternalFrame newInternalFrame() {
        final JInternalFrame inf = new JInternalFrame("Blah", false, false, false, true);
        inf.setLocation(xpos, ypos);
        inf.setSize(300, 300);
        inf.setVisible(true);

        xpos += 50;
        ypos += 50;

        JPanel jp = new JPanel();
        JLabel jl = new JLabel("panel" + xpos);

        JButton jb = new JButton("_");
        JButton jb2 = new JButton("[]");
        JButton jb3 = new JButton("X");

        inf.setLayout(new GridLayout(2, 2));
        jp.add(jl);
        jp.add(jb);
        jp.add(jb2);
        jp.add(jb3);

        inf.add(jp);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inf.setIcon(true);
//                    if (inf.getLayer() == JDesktopPane.FRAME_CONTENT_LAYER) {
//                        pane.remove(inf);
//                        pane.add(inf, JDesktopPane.DEFAULT_LAYER);
//                        pane.revalidate();
//                        pane.repaint();
//                    }
//                    inf.pack();
//                    inf.setIcon(true);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }

        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    inf.setMaximum(!inf.isMaximum());
                    if (inf.isMaximum()) {
                        ((JLayeredPane)inf.getParent()).setLayer(inf, 0);
                    } else {
                        ((JLayeredPane)inf.getParent()).setLayer(inf, 10);
                    }
//                    if (inf.isMaximum()) {//restore
//                        inf.pack();
//                    } else {//maximize
//                        inf.setMaximum(true);
//
//                    }
//                    pane.remove(inf);
//                    pane.add(inf, JDesktopPane.FRAME_CONTENT_LAYER);
//                    pane.revalidate();
//                    pane.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Container parent = inf.getParent();
                inf.dispose();
                parent.remove(inf);
                //                try {
                //                    inf.dispose();
                //                } catch (Exception ex) {
                //                    ex.printStackTrace();
                //                }

            }

        });


//        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) inf.getUI()).getNorthPane();
//        inf.remove(titlePane);
        return inf;
    }

    public class DesktopPane extends JDesktopPane {

        @Override
        public void doLayout() {
            super.doLayout();
            List<Component> icons = new ArrayList<Component>(25);
            int maxLayer = 0;

            for (Component comp : getComponents()) {
                if (comp instanceof JInternalFrame.JDesktopIcon) {
                    icons.add(comp);
                    maxLayer = Math.max(getLayer(comp), maxLayer);
                }
            }

            maxLayer++;
            int x = 0;
            for (Component icon : icons) {

                int y = getHeight() - icon.getHeight();
                icon.setLocation(x, y);
                x += icon.getWidth();
                setLayer(icon, maxLayer);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        mouseCount = me.getClickCount();
        if (mouseCount == 2) {
            System.out.println("clicked" + mouseCount);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println("clicked" + mouseCount);
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

}