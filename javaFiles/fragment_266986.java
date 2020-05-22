BaseType one = new BaseType("some",1);
BaseType two = new BaseType("some",2);
SubType three = new SubType("some",1,"else");
SubType four = new SubType("some",2,"else");
System.out.println (areFieldsEqual(one,two,BaseType::getX,BaseType::getY));
System.out.println (areFieldsEqual(three,four,SubType::getZ,BaseType::getX));