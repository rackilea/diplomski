@Override
    public void mouseReleased(MouseEvent e) {
        try {
            Thread.sleep(3000);
            //thread will then resume
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }   
    }