public static void main(String [] args){
    List<Field> list = new ArrayList<>(Arrays.asList(A.class.getDeclaredFields()));

    for(Iterator<Field> i = list.iterator(); i.hasNext();){
        Field f = i.next();
        if(f.getModifiers() != Modifier.PRIVATE)
            i.remove();
    }
    for(Field f : list)
        System.out.println(f.getName());
}