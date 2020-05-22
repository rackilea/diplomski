private Webcam wcam = Webcam.getWebcams().get(1);
private WebcamPanel wcampanel = new WebcamPanel((Webcam) wcam, ds, false);

private Webcam wcam2 = Webcam.getWebcams().get(2);
private WebcamPanel wcampanel2 = new WebcamPanel((Webcam) wcam2, ds, false);

/**
 * Creates new form pasporcheckin
 */
public pasporcheckin() {
  initComponents();

  wcam.setViewSize(cs);
  wcam2.setViewSize(cs);

  wcampanel.setFillArea(true);
  wcampanel2.setFillArea(true);

  panelCam.setLayout(new FlowLayout());

  panelCam.add(wcampanel);
  panelCam.add(wcampanel2);

}