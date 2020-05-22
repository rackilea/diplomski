for (EmployeeName r : list)
{
    if (r.getName().indexOf(textField.getText()) != -1)
    {
        System.out.println(r.getName() + " is similar");
    } 
}