for (int i = 0; i < rows.size(); i++) {
 Bean line = new Bean();
 ArrayList al=(ArrayList)rows.get(i);//now [FRPP, PE103, , USD]
 line.setField1((String)al.get(0));//FRPP
 line.setField2((String)al.get(1));//PE103
 line.setField3((String)al.get(2));// 
 line.setField4((String)al.get(3));//USD
 data.add(line);
}