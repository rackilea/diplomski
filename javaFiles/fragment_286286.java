@Override
        public void dragDropEnd(DragSourceDropEvent e) {
            m_isDrawRect = false;
            m_lineRect.setRect(0, 0, 0, 0);
            // m_dragTabIndex = -1;

            if (hasGhost()) {
                s_glassPane.setVisible(false);
                s_glassPane.setImage(null);
            }

            // if drop failed, create new JFrame with JTabbedPane included with public access
            if(!e.getDropSuccess()){
                // MenuLight class Extends JFrame and Included 1 component JTabbedPane called superPane
                MenuLight m = new MenuLight();
                m.setLocation(e.getLocation());
                m.setVisible(true);

                // after create Frame, transfer the tab to other jtabbedpane
                ((DnDCloseButtonTabbedPane) m.superPane).convertTab(getTabTransferData(e), getTargetTabIndex(e.getLocation()));
            }

            // if current JTabbedPane Tab is empty dispose it.
            if(getTabCount() < 1){
                // unfortunly i didnt want to close my Original menu, so check the class of parent of DnD is create from MenuLight and dispose it
                if(parent.getClass().equals(MenuLight.class)){
                    ((javax.swing.JFrame) parent).dispose();
                }
            }
        }