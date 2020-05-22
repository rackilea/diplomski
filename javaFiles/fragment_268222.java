Spinner staticSpinner = (Spinner)findViewById(R.id.static_spinner);
        ArrayAdapter<CharSequence> staticAdapter =
                ArrayAdapter.createFromResource(this,R.array.request_role,R.layout.spinner_item);

        staticAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);