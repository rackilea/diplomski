public void showPopup() {

    // Container layout to hold other components    
    LinearLayout llContainer = new LinearLayout(this);

    // Set its orientation to vertical to stack item
    llContainer.setOrientation(LinearLayout.VERTICAL);

    // Container layout to hold EditText and Button
    LinearLayout llContainerInline = new LinearLayout(this);

    // Set its orientation to horizontal to place components next to each other
    llContainerInline.setOrientation(LinearLayout.HORIZONTAL);

    // EditText to get input
    final EditText etInput = new EditText(this);

    // TextView to show an error message when the user does not provide input
    final TextView tvError = new TextView(this);

    // For when the user is done
    Button bDone = new Button(this);

// If tvError is showing, make it disappear 
    etInput.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            tvError.setVisibility(View.GONE);
        }
    });

    // This is what will show in etInput when the Popup is first created
    etInput.setHint("Please provide a number");

    // Input type allowed: Numbers
    etInput.setRawInputType(Configuration.KEYBOARD_12KEY);

    // Center text inside EditText
    etInput.setGravity(Gravity.CENTER);

    // tvError should be invisible at first
    tvError.setVisibility(View.GONE);

    bDone.setText("Done");

    bDone.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            // If user didn't input anything, show tvError
            if (etInput.getText().toString().equals("")) {
                tvError.setText("Please enter a valid value");
                tvError.setVisibility(View.VISIBLE);
                etInput.setText("");

            // else, call method `doneInput()` which we will define later
            } else {
                doneInput(etInput.getText().toString());
                popupWindow.dismiss();
            }
        }
    });

    // Define LayoutParams for tvError
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    layoutParams.topMargin = 20;

    // Define LayoutParams for InlineContainer
    LinearLayout.LayoutParams layoutParamsForInlineContainer = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    layoutParamsForInlineContainer.topMargin = 30;

    // Define LayoutParams for EditText
    LinearLayout.LayoutParams layoutParamsForInlineET = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    // Set ET's weight to 1 // Take as much space horizontally as possible      
    layoutParamsForInlineET.weight = 1;

    // Define LayoutParams for Button
    LinearLayout.LayoutParams layoutParamsForInlineButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    // Set Button's weight to 0     
    layoutParamsForInlineButton.weight = 0;

    // Add etInput to inline container
    llContainerInline.addView(etInput, layoutParamsForInlineET);

    // Add button with layoutParams // Order is important
    llContainerInline.addView(bDone, layoutParamsForInlineButton);

    // Add tvError with layoutParams
    llContainer.addView(tvError, layoutParams);

    // Finally add the inline container to llContainer
    llContainer.addView(llContainerInline, layoutParamsForInlineContainer);

    // Set gravity
    llContainer.setGravity(Gravity.CENTER);

    // Set any color to Container's background
    llContainer.setBackgroundColor(0x95000000);

    // Create PopupWindow
    popupWindow = new PopupWindow(llContainer, 
                                        ViewGroup.LayoutParams.MATCH_PARENT,
                                             ViewGroup.LayoutParams.WRAP_CONTENT);

    // Should be focusable
    popupWindow.setFocusable(true);

    // Show the popup window
    popupWindow.showAtLocation(llContainer, Gravity.CENTER, 0, 0);

}