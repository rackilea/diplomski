private static void loopForPanel(Container c, Color col) {
        synchronized (c.getTreeLock()) {
            for (Component com : c.getComponents()) {
                if (com instanceof JPanel) {
                    com.setBackground(col);
                }
                if (com instanceof Container) {
                    loopForPanel((Container) com,col);
                }
            }
        }
    }