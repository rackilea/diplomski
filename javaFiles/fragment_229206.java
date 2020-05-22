while (iterator.hasNext()) {
        JButton newButton = new JButton(iterator.next());
        button.add(newButton);
        container.add(newButton);
        panel2.add(newButton);
        newButton.addActionListener(this);
}