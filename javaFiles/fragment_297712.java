StringBuilder sb = new StringBuilder();
sb.append("There are ").append(count).append(" people in the following list:\n");
for (int i = 0; i < count; i++) {
    sb.append("Person #").append(count).append('\n');
}
JOptionPane.showMessageDialog(null, sb.toString());