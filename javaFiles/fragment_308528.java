catch (SQLException exceptie) {
    if (exceptie.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
        System.out.println("Numele de utilizator introdus este deja folosit!");
    } else {
        exceptie.printStackTrace(); 
    }
}