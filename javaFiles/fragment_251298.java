{
        JToggleButton[] jTableButton = new JToggleButton[] { new JToggleButton("one"), new JToggleButton("two"), new JToggleButton("three"), new JToggleButton("four")};
        table1Model =
            new DefaultTableModel(
                    new Object[][] { { jTableButton[0], false, 1 },
                                     { jTableButton[1], false, 1 },
                                     { jTableButton[2], false, 1 },
                                     { jTableButton[3], false, 1 }},
                                     columnName);

        table1 = new JTable(table1Model){
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                int value = (Integer) table1Model.getValueAt(rowIndex, 2);

                String blueColor = Color.BLUE;
                String redColor = Color.RED;
                String selectedColor = Color.GREEN;

                String colorValue = selectedColor;

                if ( value > 0) {
                    colorValue = blueColor; //blue
                }
                else {
                    colorValue = redColor; //red
                }

                return !colorValue.equals(redColor); // Disallow the editing of red cell
            }

            @Override
            public Class<?> getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }

            @Override
            public Component prepareRenderer(TableCellRenderer renderer,int rowIndex, int vColIndex)
            {
                int value = (Integer) table1Model.getValueAt(rowIndex, 2);

                String blueColor = Color.BLUE;
                String redColor = Color.RED;
                String selectedColor = Color.GREEN;

                String colorValue = selectedColor;

                if ( value > 0) {
                    colorValue = blueColor; //blue
                }
                else {
                    colorValue = redColor; //red
                }

                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                if (!isCellSelected(rowIndex, vColIndex))
                {

                    if (vColIndex != 0 ) {
                        c.setEnabled(!colorValue.equals(redColor));
                    }
                    else {
                        c.setEnabled(!colorValue.equals(redColor));

                        if (colorValue.equals(redColor))
                            c.setBackground(Color.decode(colorValue));
                    }

                    if (c instanceof JToggleButton && vColIndex == 0){
                        JToggleButton button = (JToggleButton) c;
                        button.setToolTipText(((JToggleButton) c).getText());
                    }

                    if (   Color.decode(colorValue).getRed() >= 224
                            && Color.decode(colorValue).getGreen() >= 224
                            && Color.decode(colorValue).getBlue() >= 224){

                        c.setForeground(Color.gray);

                    }
                    else {

                        c.setForeground(Color.white);
                    }
                }
                return c;
            }

        };

        scrollPane1.setViewportView(table1);
        table1.setPreferredSize(new java.awt.Dimension(187,290));
        table1.setFont(new java.awt.Font("Segoe UI",0,14));
        table1.getColumnModel().getColumn(0).setCellRenderer(new JToggleButtonRenderer());
    }