SwingWorker worker = new SwingWorker<Boolean, Void>() {
    @Override
    public String doInBackground() {
        return "<html><center>Lecture X : " + ticketDAO.getLectureX() + "</center></html>";
    }

    @Override
    public void done() {
        lectureXlabel.setText(get());
        lectureXlabel.revalidate();
        lectureXlabel.repaint();
        componentsPanel.revalidate();
        componentsPanel.repaint();
        getContentPane().revalidate();
        getContentPane().repaint();
    }
};