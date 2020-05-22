public void showProfessorList(){
    StringBuilder sb = new StringBuilder(25);
    sb.append("<html>");
    for (int i=0; i < professorList.size(); i++){
        sb.append(professorList.get(i).getName())).append("<br>");
    }
    JOptionPane.showConfirmDialog(this,
                                  new JScrollPane(new JLabel(sb.toString),
                                  "Behold",
                                  JOptionPane.OK_CANCEL_OPTION,
                                  JOptionPane.PLAIN_MESSAGE);    
}