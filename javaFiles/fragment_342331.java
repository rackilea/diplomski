switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        mtrGpio = manager.openGpio("BCM24");
                        mtrGpio.setEdgeTriggerType(Gpio.EDGE_NONE);
                        mtrGpio.setActiveType(Gpio.ACTIVE_HIGH);
                        mtrGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                        mtrGpio.setValue(true);
                        Log.i(TAG, "Motor started");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        mtrGpio.setValue(false); // ADD THIS
                        mtrGpio.close();

                        return true; // if you want to handle the touch event
                }