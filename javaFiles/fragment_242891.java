timer2 = new Timer(250, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (y > 6) {
            timer2.stop();
            Container parent = label.getParent();
            parent.remove(label);
            parent.add(TO);
            parent.revalidate();
        } else {
            label.setIcon(icon[y]);
            y++;
        } //ends if-else
    } //ends action method
}); //ends timer2