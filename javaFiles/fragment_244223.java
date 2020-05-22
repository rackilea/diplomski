Child child = new Child();
try {
        Method method = Base.class.getDeclaredMethod("getHi", String.class);
        method.setAccessible(true);
        String output = (String) method.invoke(child, "Tuk");
        System.out.println(output);
    } catch (Exception e) {
        e.printStackTrace();
    }