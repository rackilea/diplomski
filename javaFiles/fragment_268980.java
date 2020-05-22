Map<Integer, JTextArea> indexToTextArea = new HashMap<>();//Instance variable
....
//in the MouseListener:
JTextArea textArea = new JTextArea();
viewerPane.addTab((String) table.getValueAt(row, 0), null , new JPanel().add(textArea), (String) table.getValueAt(row, 0));
viewerPane.setSelectedIndex(viewerPane.getComponentCount()-1);
indexToTextArea.put(viewerPane.getComponentCount()-1, textArea);