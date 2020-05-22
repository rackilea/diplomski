List<Employee> employeeList = new ArrayList<Employee>();
FileInputStream fis = null;
ObjectInputStream in = null;
try {
    fis =new FileInputStream("./employee.txt");
    in = = new ObjectInputStream(fis);
    while (true) {
        employeeList.add((Employee) in.readObject());
    }
} catch (EOFException eof) {
    // Ignore. means you reached EOF
} finally {
    if (fis != null)
        fis.close(); // close the stream
    if(in != null)
        in.close();
}