class A{

    private void a(){
        System.out.println("private of A called");
    }
}

class B extends A{

    public void callAa(){
        try {
            System.out.println(Arrays.toString(getClass().getSuperclass().getMethods()));
            Method m = getClass().getSuperclass().getDeclaredMethod("a", new Class<?>[]{});
            m.setAccessible(true);
            m.invoke(this, (Object[])null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}