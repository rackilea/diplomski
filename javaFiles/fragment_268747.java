private JPanel createPanel(){
        int copyCounter = count; // Copy the counter
        count++;
        JPanel app = new JPanel(true);
        app.setLayout(new GridLayout(1,1);
        app.setPreferredSize(new Dimension(width,dHeight));
        JButton btn = createButton("Click Me");
        buttonStyle(btn);
        btn.addActionListener(e -> this.doStuff(copyCounter)); // Use copy here
        app.add(btn);

        return app;
}