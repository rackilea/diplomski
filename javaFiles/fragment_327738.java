PropertyChangeListener listener = new PropertyChangeListener(){
            public void propertyChange(PropertyChangeEvent event){
                if("progress".equals(event.getPropertyName())){
                    currentPercent = (int)event.getNewValue();
                    progressBar.setValue(currentPercent);
                    progressBar.setString(Integer.toString(currentPercent));
                }
            }
        };