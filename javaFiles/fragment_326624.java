public static void StringNullOREmpty(Pojo po) {

    Field[] f = po.getClass().getDeclaredFields();
    Arrays.stream(f).forEach(i->{;
    i.setAccessible(true); // need to be true to access private fields of pojo class
       try {
           if(i.get(po)!=null && !i.get(po).toString().trim().isEmpty()) {
               System.out.println(i.get(po).toString()+" filed name "+i.getName());
           }
    } catch (IllegalArgumentException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    });

}