public void showNextImage() {
    try {
        Collections.shuffle(imageFiles);

        File imageFile = imageFiles.remove(0);

        jLabel.setIcon(new ImageIcon(ImageIO.read(imageFile)));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

public void openImageWindow(int delay) {

    imageFiles = new ArrayList<>(Arrays.asList(new File(rootFolder.getText()).listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(".jpg")
                    || pathname.getName().toLowerCase().endsWith(".png")
                    || pathname.getName().toLowerCase().endsWith(".bmp")
                    || pathname.getName().toLowerCase().endsWith(".gif");
        }
    })));

    imageFrame = new JFrame("Slideshow v1.0");
    imageFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    imageFrame.setLayout(new BorderLayout());
    imageFrame.setSize(400, 400);
    File file = new File(rootFolder.getText());
    List list = Arrays.asList(file.list());
    Random random = new Random();
    int i = random.nextInt(list.size());
    imageIcon = new ImageIcon(list.get(i).toString());
    haveUsed.add(list.get(i).toString());
    jLabel = new JLabel(imageIcon);
    jLabel.setSize(399, 399);
    imageFrame.add(jLabel);
    Timer timer = new Timer(delay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            showNextImage();
        }
    });
    imageFrame.setVisible(true);
    timer.setInitialDelay(0);
    timer.start();


}