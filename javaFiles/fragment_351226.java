final JTextField ageTextField = new JTextField(20);
ageTextField.setEditable(false);

JDateChooser dateChooser = new JDateChooser(new Date());
dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Calendar dateofBirth = Calendar.getInstance();
        dateofBirth.setTime((Date)evt.getNewValue());

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateofBirth.get(Calendar.YEAR);

        if(today.get(Calendar.MONTH) < dateofBirth.get(Calendar.MONTH) ||
          (today.get(Calendar.MONTH) == dateofBirth.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dateofBirth.get(Calendar.DAY_OF_MONTH))) {                    
            age--;
        }

        ageTextField.setText(String.valueOf(age));
    }
});