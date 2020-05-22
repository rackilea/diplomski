layout.setHorizontalGroup(layout
  .createSequentialGroup()
  .addComponent(label, labelWidth, labelWidth, labelWidth)
  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                   GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
  .addGroup(layout
              .createParallelGroup(GroupLayout.Alignment.CENTER)
              .addComponent(installButton, BUTTON_WIDTH, BUTTON_WIDTH,
                            BUTTON_WIDTH).addComponent(installProgressBar)
              .addComponent(updateLabel).addComponent(updateButton)
              .addComponent(removeButton)));

layout.setVerticalGroup(layout
  .createParallelGroup()
  .addComponent(label)
  .addGroup(layout
              .createSequentialGroup()
              .addComponent(installButton)
              .addGroup(layout.createParallelGroup()
                          .addComponent(installProgressBar)
                          .addComponent(updateLabel))
              .addComponent(updateButton).addComponent(removeButton)));

layout
  .linkSize(SwingConstants.HORIZONTAL, installButton, installProgressBar,
            updateLabel, updateButton, removeButton);