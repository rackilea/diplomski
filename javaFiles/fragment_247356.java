int rowsUpdated = pstmnt.executeUpdate();
if (rowsUpdated == 0) {
    System.out.println("User does not exist");
} else {
    System.out.println("User deleted");
}