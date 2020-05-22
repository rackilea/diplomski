public class Test {
    private long xBalance = 5L;
    private long yBalance = 10L;
    private long nuhuh = 20L;

    public long getTotal() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
        long result = 0L;
        for(Field field : this.getClass().getDeclaredFields()){
            if(field.getName().endsWith("Balance")){
                result += (long) field.get(this);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        System.out.println(new Test().getTotal());
    }
}