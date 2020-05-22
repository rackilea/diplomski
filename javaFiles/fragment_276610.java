ps.setString(1, firstName);
ps.setString(2, lastName);
ps.setString(3, fileName);
ps.setString(4, path);
int status = ps.executeUpdate();

if (status > 0) {
    System.out.println("File Uploaded Successfully");
    System.out.println("Uploaded Path:" + uploadPath);
}