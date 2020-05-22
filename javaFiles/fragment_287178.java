....
for (int i = 0; i < list.getLength(); i++) {
    try {
        String insertCommand = "INSERT INTO command SET .........";
        System.out.println("\n SET INSERT :" + insertCommand);
        int count = stmt1.executeUpdate(insertCommand);
        } catch (Exception e) {
            // Better catch the real exception
            // Handle the exception 
        }
}
....