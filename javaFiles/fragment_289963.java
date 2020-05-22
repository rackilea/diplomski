we.locationProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(startRecording > 0)
                {
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    if((duration / 1000000000) >= 1)
                    {
                        System.out.println("duration: " + (duration / 1000000000) + " seconds");
                    }
                }
                startRecording++;
                txt.setText(newValue);
            }
        });