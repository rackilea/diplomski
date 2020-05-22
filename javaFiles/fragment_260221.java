String birthDate = request.getParameter("data_birthdate");
// assuming your text birthdates look like 1980-12-30 00:30:05
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime dt = LocalDateTime.parse(birthDate, formatter);

try {
    connect = db.getConnect();
    ps = connect.prepareStatement(SQL_CreateUser);
    ps.setTimestamp(3, Timestamp.valueOf(dt));
}
catch (Exception e) {
    // handle exception
}