IntegerWrapper i1 = new IntegerWrapper(11);
IntegerWrapper i2 ;
i2 = i1;
System.out.println(i1.getValue()+"   "+i2.getValue());
i1.setValue(233);
System.out.println(i1.getValue()+"   "+i2.getValue());