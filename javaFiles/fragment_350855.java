compdate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent e) {

             if ("date".equals(e.getPropertyName())) 
                {
                    System.out.println(e.getPropertyName()
                        + ": " + (Date) e.getNewValue());
                }
            }
        });