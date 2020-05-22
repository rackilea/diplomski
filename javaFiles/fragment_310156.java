private class ShoulderMovementProcessorThread extends Thread {

               .....

               // this will be called from the UI thread, just add event to the (synchronized) queue.

               public void publish (int[] valuesAccelerometer, int[] valuesWhatever) {

                     add_event_to_queue();

               }

               // this is the typical event loop where you read one from the queue, process it, then wait for the next
               public void run() {
                   -> get event
                   -> process event
                   -> wait for next event
               }

        }

        ShoulderMovementProcessorThread mShoulderProcessor=new ShoulderMovementProcessorThread(...);

        @Override
        public void onSensorChanged(SensorEvent event) {
              decodeEvent (event); // fills up azimuth, roll, etc.
              mShoulderProcessor.publish(valuesAccelerometer, valuesWhatever);           

        }


        // decode an event
        private void decodeEvent (SensorEvent event) {

            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                valuesAccelerometer = lowPass(event.values.clone(), valuesAccelerometer);
            } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                valuesMagneticField = lowPass(event.values.clone(), valuesMagneticField);
            }
            if (valuesAccelerometer != null && valuesMagneticField != null) {
                SensorManager.getRotationMatrix(matrixR, matrixI, valuesAccelerometer, valuesMagneticField);

                if(true){
                    SensorManager.getOrientation(matrixR, matrixValues);

                    double azimuth = Math.toDegrees(matrixValues[0]);
                    double pitch = Math.toDegrees(matrixValues[1]);
                    double roll = Math.toDegrees(matrixValues[2]);

                    valuesOrientation[0]=(float) pitch;
                    valuesOrientation[1]=(float) roll;
                    valuesOrientation[0]=(float) azimuth;

                }

            }
        }