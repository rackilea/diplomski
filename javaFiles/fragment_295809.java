String s =  "fruit;mango;apple;banana" ;
String[] elements = s.split(";");
if(elements.length > 0){
    if(elements[0].equals("fruit")){
        String[] fruits = new String[elements.length-1];
        System.arraycopy(elements, 1,fruits , 0, elements.length-1);
        System.out.println(Arrays.toString(fruits));
    }
}