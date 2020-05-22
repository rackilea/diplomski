for (EmployeeName r : list)
{
    if (r.getName().startsWith(textField.getText()))
    {
        System.out.println(r.getName() + " is similar");
    } 
}