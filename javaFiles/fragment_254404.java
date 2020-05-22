StringBuilder all = new StringBuilder();

for (int i = 1; i < text.length; i++) {
    all.append(text[i]);
    if (i != text.length - 1) all.append(" ");
}

JOptionPane.showMessageDialog(frame, all.toString());