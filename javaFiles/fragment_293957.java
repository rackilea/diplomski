public class EmployeeRecordToJTextfield {
  private EmployeeRecord employeeRecord;
  private JTextField jTextField;

  public EmployeeRecordToJTextfield(EmployeeRecord employeeRecord, JTextField jTextField) {
    this.employeeRecord = employeeRecord;
    this.jTextField = jTextField;
  }

  public EmployeeRecord getEmployeeRecord() {
    return employeeRecord;
  }

  public JTextField getJTextField() {
    return jTextField;
  }
}