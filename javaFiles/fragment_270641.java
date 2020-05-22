public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("q1")) {
     start = true;
     radButton1.setVisible(true);
     radButton2.setVisible(true);
     radButton3.setVisible(true);
     radButton4.setVisible(true);
     question1.setVisible(true);
     next1.setVisible(true);
     System.out.println("Q1");
  }
  if (e.getActionCommand().equals("q2")) {
     radButton1.setVisible(false);
     radButton2.setVisible(false);
     radButton3.setVisible(false);
     radButton4.setVisible(false);
     question1.setVisible(false);
     next1.setVisible(false);
     System.out.println("Q2");
     checkBox1.setVisible(true);
     checkBox2.setVisible(true);
     checkBox3.setVisible(true);
     checkBox4.setVisible(true);
     question2.setVisible(true);
     next2.setVisible(true);
  }
  if (e.getActionCommand().equals("q3")) {
     next2.setVisible(false);
     checkBox1.setVisible(false);
     checkBox2.setVisible(false);
     checkBox3.setVisible(false);
     checkBox4.setVisible(false);
     question2.setVisible(false);
     System.out.println("Q3");
     question3.setVisible(true);
     finish.setVisible(true);
  }
  if (e.getActionCommand().equals("end")) {
     question3.setVisible(false);
     finish.setVisible(false);
     score.setVisible(true);
     finish.setVisible(true);
  }
}