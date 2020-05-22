public void actionPerformed(ActionEvent e)
{
    if(e.getSource() == reportButton && patient != null)
    {
        System.out.println("I'm Clicked!");
        patient.setAge(ageField, log);
    }
}