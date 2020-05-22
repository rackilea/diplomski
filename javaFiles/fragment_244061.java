public static ArrayList<String> addEmployeeNames(HBox pane, TextField tf, ArrayList<String> employees)
{
    employees.add(tf.getText());

    tf.clear();

    return employees;
}