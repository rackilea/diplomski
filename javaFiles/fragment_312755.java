class FaceFrame extends JFrame {

    private FacePanel myFacePanel;

    public FaceFrame(ArrayList<Face> faceListIn, int width, int height) {
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FacePanel myFacepanel = new FacePanel(faceListIn);
    }

}