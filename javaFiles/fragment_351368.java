try {
    Class<?> yourClass= Class.forName("yourClassName");
    Intent intent = Intent(context,yourClass)

 } catch (ClassNotFoundException e) {
        e.printStackTrace();
}