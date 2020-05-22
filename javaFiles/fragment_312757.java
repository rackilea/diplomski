class FacePanel extends JPanel {

    private ArrayList<Face> FaceList;

    public void setFaceList(ArrayList<Face> FaceListIn) {
        FaceList = FaceListIn;
    }

    //draw panel
    FacePanel() {
        super();
    }

    FacePanel(ArrayList<Face> FaceListIn) {
        setFaceList(FaceListIn);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Face oD : FaceList) {
            oD.paintComponent(g);
        }
    }
}