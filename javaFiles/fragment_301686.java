JFrame frame = new JFrame("Testing");
frame.setLayout(new BorderLayout());

StringBuilder sb = new StringBuilder(128);
sb.append("<html><table>");
sb.append("<tr><td>12345678</td>-12,231<td></tr>");
sb.append("<tr><td>1234</td>-123.000<td></tr>");
sb.append("</table></html>");

frame.add(new JLabel(sb.toString()));

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);