try {
    myButton.addListener(new GpioPinListenerDigital() {

        private boolean pressed = false;
        private boolean released = false;

        @Override
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                String state = event.getState().toString();
                if (state.equalsIgnoreCase("HIGH")) {
                       pressed = true;
                       released = !pressed;
                } else {
                       released = true;
                       pressed = !released;
                }

                // Do what you want with it.
            }
        });
    } catch(NullPointerException e2) {

    }