int index = list.locationToIndex(p);
Object value = list.getModel().getElementAt(int);
Component comp = listCellRenderer.getListCellRendererComponent(list, value, index, true, true);
comp.setBounds(list.getCellBounds(index, index));
Point contextPoint = SwingUtilities.convertPoint(list, p, comp);
Component child = comp.getComponentAt(contextPoint);