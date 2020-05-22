//wait for dialog fragment
        solo.waitForFragmentByTag(DatePicker_Fragment.TAG);

        //get a reference to dialog fragment
        SherlockFragmentActivity current_activity = (SherlockFragmentActivity) solo.getCurrentActivity();
        DatePicker_Fragment dp_frag = (DatePicker_Fragment) current_activity.getSupportFragmentManager().findFragmentByTag(DatePicker_Fragment.TAG);

        //wait until dialog fragment is visible on screen
        assertNotNull(dp_frag);
        while(!(dp_frag.isShown())){
            Log.w(getName(), "Dialog fragment visible " + dp_frag.isShown());
            solo.sleep(100);
        }

        //set the start date
        DatePickerDialog dp_dialog = (DatePickerDialog) dp_frag.getDialog();
        assertNotNull(dp_dialog);
        DatePicker datePicker = dp_dialog.getDatePicker();
        solo.setDatePicker(datePicker,2013,5,21);
        solo.clickOnView(dp_dialog.getButton(DatePickerDialog.BUTTON_POSITIVE));