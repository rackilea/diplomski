while (rs.next()) {
    a = rs.getString(1);
    b = rs.getString(2);
    // create a new vector corresponding to each record in the result set
    emp = new Vector<String>();
    emp.add(a);
    emp.add(b);
    System.out.println(a + "  " + b);

    empvector.add(emp);
}