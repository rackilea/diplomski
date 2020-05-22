class UserPanel extends JPanel implements Observer {
  tf = new JTextField();
}

@Override
public void update(Observable o, Object ob) {
  User u=(User) ob;
  tf.setText(u.getName());
}