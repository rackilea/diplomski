public void open()
{
    JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
    System.out.println("open(): entry - With frame");
    frame.setSize(300,300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    JOptionPane.showConfirmDialog(frame, "Wow, works on the Mac!", "Inside open()", JOptionPane.YES_NO_OPTION);
    System.out.println("Point 1");

    System.exit(0);
}