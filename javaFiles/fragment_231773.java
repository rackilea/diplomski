Runnable task = new Runnable() {
            @Override
            public void run() {
                c.updateData();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            infoLogTextArea.appendText(c.getErrorLog().toString());
                            plotLabel.setText(c.getCityData().size()+" cities found and updated from internet");
                            infoLogTextArea.appendText("Successfully updated the data from Internet\n");
                        }catch (IOException e) {
                            infoLogTextArea.setText("Couldnot update the data from web: "+e.getMessage()+"\n");
                        }
                        finally {
                            plotButton.setDisable(false);
                            updateButton.setDisable(false);
                        }
                    }
                });
            }
        };