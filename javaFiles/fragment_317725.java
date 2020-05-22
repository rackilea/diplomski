private void ChangeToLandscape(boolean landscape)
        {
            if (landscape)
                {
                    hintTextView = (TextView) findViewById(R.id.hint_text2);
                    foundTextView = (TextView) findViewById(R.id.num_found_text2);
                    tvLastBarcode = (TextView) findViewById(R.id.tv_lastBarcode2);
                    doneButton = (Button) findViewById(R.id.button_done2);
                    bMultiscan = (Button) findViewById(R.id.bMultiscan2);
                    toggleTorchButton = (Button) findViewById(R.id.button_toggle_torch2);
                    toggleLineButton = (Button) findViewById(R.id.button_toggle_line2);
                    bRotate = (Button) findViewById(R.id.bRotate2);
                    viewfinderView = findViewById(R.id.view_finder2);

                } else
                {
                    hintTextView = (TextView) findViewById(R.id.hint_text);
                    foundTextView = (TextView) findViewById(R.id.num_found_text);
                    tvLastBarcode = (TextView) findViewById(R.id.tv_lastBarcode);
                    doneButton = (Button) findViewById(R.id.button_done);
                    bMultiscan = (Button) findViewById(R.id.bMultiscan);
                    toggleTorchButton = (Button) findViewById(R.id.button_toggle_torch);
                    toggleLineButton = (Button) findViewById(R.id.button_toggle_line);
                    bRotate = (Button) findViewById(R.id.bRotate);
                    viewfinderView = findViewById(R.id.view_finder);
                }
    //and then we re-assign the buttons delegates
    doneButton.setOnClickListener(new OnClickListener()
                {
                    public void onClick(View v)
                        {
                            doneScanning();
                        }
                }); //....etc
    }