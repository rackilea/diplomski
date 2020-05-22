layout.setHorizontalGroup(layout
    .createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addComponent(one, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(two, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(three, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    .addGroup(layout.createSequentialGroup()
        .addComponent(four, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(five, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    .addComponent(six, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

layout.setVerticalGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(one).addComponent(two).addComponent(three))
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(four).addComponent(five))
    .addComponent(six));