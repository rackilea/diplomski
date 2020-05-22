public class DateTextField extends JTextField implements Observer {

public void update(Observable o, Object arg) {
    Calendar calendar = (Calendar) arg;
    DatePicker dp = (DatePicker) o;
    setText(dp.formatDate(calendar));
}

public DateTextField() {
    final Observer obs = this;
    final JTextField tf = this;
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(tf.isEditable()){
                Point p = e.getPoint();
                if(p.x>=getWidth()-22 && p.x <getWidth()
                        && p.y<=getHeight()) {
                    DatePicker dp = new DatePicker(obs);
                    Date selectedDate = dp.parseDate(tf.getText());
                    dp.setSelectedDate(selectedDate);
                    dp.start(tf);
                }
            }
        }
    });

    this.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            Point p = e.getPoint();
            if(p.x>=getWidth()-22 && p.x <getWidth()
                    && p.y<=getHeight()) {
                DateTextField.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }else {
                DateTextField.this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            }
        }
    });
}

public DateTextField(String text) {
    this();
    this.setText(text);
}

@Override
public void paint(Graphics g) {
    super.paint(g);
    try {
        BufferedImage img = ImageIO.read(new File(DateTextField.class.getResource("/images/calendar.png").getFile()));
        int x=getWidth()-22;
        g.drawImage(img,x,1,20,getHeight()-2,null);
    }catch (IOException e) {
        e.printStackTrace();
    }
}
}