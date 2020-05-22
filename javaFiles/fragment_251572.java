public class MyKeyGenerator extends DefaultKeyGenerator {

    @Override
    public Object generate(Object target, Method method, 
            Object... params) {

        MyKeyGenerator myKeyGenerator = 
            method.getAnnotation(MyKeyGenerator.class);
        if (myKeyGenerator != null) {
            // read your annotation and invoke the proper
            // key generator according to the value
        } else {
            super.generate(target, method, params);
        }
    }
}