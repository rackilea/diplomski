public class ReflectionTest {

        public static void main(String[] args){
            Method[] m = ReflectionTest.class.getDeclaredMethods();
            for (Method method : m) {
                System.out.println(method.getName());
            }               

            try {
                Method m1 = ReflectionTest.class.getDeclaredMethod("d0", int.class, boolean.class);
                if(m1 != null){
                    System.out.println("m1 found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 

            try {
                Method m2 = ReflectionTest.class.getDeclaredMethod("d0", Integer.TYPE, Boolean.TYPE);
                if(m2 != null){
                    System.out.println("m2 found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 

            try {
                Class<?>[] carr = m[1].getParameterTypes();
                Method m3 = ReflectionTest.class.getDeclaredMethod("d0", carr);
                if(m3 != null){
                    System.out.println("m3 found!");
                }
            } catch (Exception e){
                e.printStackTrace();
            } 
        }

        public void d0(int a, boolean b){

        }
    }