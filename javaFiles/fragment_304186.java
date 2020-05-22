private JLabel[] labels = new JLabel[10];

for (int i=0; i<10; i++) {
    labels[i] = new JLabel();
}

/* ... */

for (int i=0; i<10; i++) {
    labels[i].setText("Hello from label " + i);
}