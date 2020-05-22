if (rs.next()) {
    String student = rs.getString("StudentID");
    String date = rs.getString("date");
    System.out.println(student+"");
    System.out.println(date);
    JOptionPane.showMessageDialog(frmAttendanceHistory,
       "Attendance has been registered.");
    frmAttendanceHistory.setVisible(false);
} else {
    JOptionPane.showMessageDialog(frmAttendanceHistory,
        "A record for the given Student ID doesn't exist");
}