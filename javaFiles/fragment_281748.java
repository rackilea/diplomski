String[] a = new String[]{"H","E","L","L","O"};
MethodCalling mc = new MethodCalling("wat.SizeChecker");
mc.setMethod("isTooBig", Comparable[].class);
/* change here: place the single parameter into a parameter array */
Boolean result1 = (Boolean) mc.callMethod(new Object[]{a});
System.out.println("too big="+result1);

mc.setMethod("isCorrectLength",Comparable[].class, int.class);
/* since the callMethod accepts varargs, these are automatically placed in an Object[] */
Boolean result2 = (Boolean) mc.callMethod(a, 5);
System.out.println("length is 5="+result2);