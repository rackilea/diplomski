public class TrimPath {

    public static void main(String[] args) {
        new TrimPath();
    }

    public TrimPath() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                File path = new File("C:\\Users\\Default\\AppData\\Local\\Microsoft\\Windows\\GameExplorer");
                TrimmedLabel label = new TrimmedLabel(path.getPath());
                label.setIcon(FileSystemView.getFileSystemView().getSystemIcon(path));

                frame.add(label);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TrimmedLabel extends JLabel {

        private String masterText;

        public TrimmedLabel(String text) {
            super(text);
        }

        @Override
        public void setText(String text) {
            if (masterText == null ? text != null : !masterText.equals(text)) {
                masterText = text;
                super.setText(text);
            }
        }

        @Override
        public String getText() {

            String text = getMasterText();

            if (text != null && text.length() > 0) {
                int width = getWidth();
                Icon icon = getIcon();
                if (icon != null) {
                    width -= (icon.getIconWidth() + getIconTextGap());
                }
                FontMetrics fm = getFontMetrics(getFont());
                if (width > 0 && fm != null) {
                    int strWidth = fm.stringWidth(text);
                    if (strWidth > width) {
                        StringBuilder sb = new StringBuilder(text);
                        String prefix = "...";
                        while (fm.stringWidth(prefix + sb.toString()) > width) {
                            sb.delete(0, 1);
                        }
                        text = prefix + sb.toString();
                    }
                }
            }
            return text;
        }

        public String getMasterText() {
            return masterText;
        }
    }
}