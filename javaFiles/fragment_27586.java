splitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, 
            new java.beans.PropertyChangeListener() {
               @Override
               public void propertyChange(java.beans.PropertyChangeEvent pce) {
                  SwingUtilities.invokeLater(
                     new Runnable() {
                        public void run()   {
                           Component left = splitPane.getLeftComponent();
                           Component right = splitPane.getRightComponent();
                           left.setPreferredSize(left.getSize());
                           right.setPreferredSize(right.getSize());
                        }
                     });
               }
            });