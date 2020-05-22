public class DesignPicture2 {

    public static void main(String[] args) throws Exception {

        DesignPicture2 mm = new DesignPicture2();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Image panel");
        frame.setSize(800, 500);
        frame.setLocation(600, 300);

        JList imageList = createImageList();

        frame.getContentPane().add(new JScrollPane(imageList));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static JList createImageList() {

        EditableList<ImagePreview> imageList = new EditableList(createModel("..."));
        imageList.setEditor(new ImagePreviewListCellEditor());
        imageList.setCellRenderer(new ImageCellRenderer());
        imageList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        imageList.setVisibleRowCount(0);
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        imageList.setFixedCellWidth(240);
        imageList.setFixedCellHeight(120);

        return imageList;
    }

    private static MutableListModel<ImagePreview> createModel(String path) {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        DefaultMutableListModel<ImagePreview> model = new DefaultMutableListModel<>();

        int count = 0;
        for (int i = 0; i < listOfFiles.length - 1; i++) {
            System.out.println("check path: " + listOfFiles[i]);
            String name = listOfFiles[i].toString();

            if (name.endsWith("jpg")) {
                try {
                    ImageIcon ii = new ImageIcon(ImageIO.read(listOfFiles[i]));
                    model.addElement(new ImagePreview(name, ii));

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return model;
    }
}