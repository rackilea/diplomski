@Component
public class MyKeyGenerator implements KeyGenerator{

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        if (String.class.isInstance(objects[0])) {
            return ....
        }
        else if (....) {

    }
}