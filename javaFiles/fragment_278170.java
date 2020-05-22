public void actionPerformed(ActionEvent e)
{
    if (patient == null)
    {
        patient = new Patient();
    }

    if(e.getSource() == reportButton)
    {
        System.out.println("I'm Clicked!");
        patient.setAge(ageField, log);
    }
}