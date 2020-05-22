Example<Integer> e = new Example<>();
e.setNum( Integer.valueOf(10) );
// returning num as Integer
Integer i = e.getNum();
// and this won't compile
e.setNum( Double.valueOf(10.0) );