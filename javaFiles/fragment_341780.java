public static void main(String[] args){
        String h = "Hello";
        System.out.println(h);
        System.out.println("Hello");
    }
     static {
            try {
               Field value = String.class.getDeclaredField("value");
               value.setAccessible(true);
               value.set("Hello", value.get("G'Day Mate."));
            } catch (Exception e) {
              throw new AssertionError(e);
            }
        }