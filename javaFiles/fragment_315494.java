JXDatePicker dp = new JXDatePicker();
    dp.getEditor().addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            // Calculate age
            Date date = dp.getDate();
        }
    });