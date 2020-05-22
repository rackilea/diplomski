public FaceFrame(ArrayList<Face> faceListIn, int width, int height) {
    setBounds(100, 100, 900, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FacePanel myFacepanel = new FacePanel(faceListIn);
    // This might be a good place to start
    add(myFacepanel);
}