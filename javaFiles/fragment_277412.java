final JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

final JDesktopPane desktopPane = new JDesktopPane();
desktopPane.add(new JInternalFrame("1") {
    {
        setVisible(true);
        setSize(100, 100);
    }
});
desktopPane.add(new JInternalFrame("2") {
    {
        setVisible(true);
        setSize(100, 100);
    }
});
desktopPane.add(new JInternalFrame("3") {
    JButton b = new JButton("Get z-order");
    {
        setVisible(true);
        setSize(100, 100);
        getContentPane().add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JInternalFrame[] iframes = desktopPane.getAllFrames();
                for (JInternalFrame iframe : iframes)
                {
                    System.out.println(iframe + "\t" +
                            desktopPane.getComponentZOrder(iframe));
                }
            }
        });
    }
});

f.setContentPane(desktopPane);
f.setLocation(100, 100);
f.setSize(400, 400);
f.validate();
f.setVisible(true);