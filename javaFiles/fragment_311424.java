while ((aLine = in.readLine()) != null) {
    String[] tokens = aLine.split(" ");

    Employee emp = new Employee();
    emp.setUser_id(tokens[0]);
    emp.setmDate(tokens[1]);
    employeArrayList.add(emp);

    out.write(aLine);
    out.newLine();
}