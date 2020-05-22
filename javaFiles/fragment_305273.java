public void addNumbers(List<String> contactNumbers) {

    LinearLayout numberLayout = (LinearLayout) findViewById(R.id.contact_numbers);

    for (String number : contactNumbers) {

        PhoneView phoneView = new PhoneView(this);
        phoneView.setContactNumber(number);
        numberLayout.addView(phoneView);
    }
}