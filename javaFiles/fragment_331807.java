SpringLayout layout = new SpringLayout();
JPanel textAndUsers = new JPanel(layout);

SpringLayout.Constraints scrollPaneConstraints =
    new SpringLayout.Constraints(scrollPane);

Spring scrollPaneWidth = scrollPaneConstraints.getWidth();
SpringLayout.Constraints listConstraints =
    new SpringLayout.Constraints(scrollPaneWidth,
                                 scrollPaneConstraints.getY(),
                                 Spring.scale(scrollPaneWidth, 0.25f),
                                 scrollPaneConstraints.getHeight());

layout.putConstraint(SpringLayout.EAST, textAndUsers, 0,
                     SpringLayout.EAST, frmUserList);
layout.putConstraint(SpringLayout.SOUTH, textAndUsers, 0,
                     SpringLayout.SOUTH, scrollPane);

textAndUsers.add(scrollPane, scrollPaneConstraints);
textAndUsers.add(frmUserList, listConstraints);