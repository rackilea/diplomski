// Create the observer which updates the response when a new value arrives.
    final Observer<String> nameObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable final String response) {
            // Update the UI like a TextView text or do whatever you want with your [response] value
            responseTextView.setText(response);
        }
    };

    // Observe the MutableLiveData, passing the observer.
    response.observe(this, nameObserver);