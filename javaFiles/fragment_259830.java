if (applicationSettings.class.getResourceAsStream("/files/Employees.xlsx") != null) {
    System.out.println("File Found");
    fileInputStream = new FileInputStream("/files/Employees.xlsx");
} else {
    System.out.println("File Not Found");
}