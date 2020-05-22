public interface ITransformer<S, T> {

    public void transform(S source, T target);

    default String getTransformerName() {
        Type[] genericInterfaces = this.getClass().getGenericInterfaces();

        ParameterizedType parameterizedType = null;

        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType paramInterface = (ParameterizedType) genericInterface;
                if (paramInterface.getRawType().equals(ITransformer.class)) {
                    parameterizedType = paramInterface;
                    break;
                }
            }
        }

        if (parameterizedType == null) {
            throw new IllegalStateException("!");
        }

        return parameterizedType.getActualTypeArguments()[0].getTypeName() + parameterizedType.getActualTypeArguments()[1].getTypeName();  

    }
}

public class StringToIntegerTransfomer implements ITransformer<String, Integer> {

    @Override
    public void transform(String source, Integer target) {

    }
}

public interface StringToNumberTransfomer<T extends Number> extends ITransformer<String, T> {

}

public class StringToLongTransfomer implements StringToNumberTransfomer<Long>, ITransformer<String, Long> {
    @Override
    public void transform(String source, Long target) {

    }
}

@Test
public void test() {
    ITransformer<String, Integer> intTransformer = new StringToIntegerTransfomer();
    ITransformer<String, Long> longTransformer = new StringToLongTransfomer();
    ITransformer<String, String> stringTransformer = new ITransformer<String, String>() {

        @Override
        public void transform(String source, String target) {

        }
    };
    ITransformer<String, Double> doubleTransformer = new StringToNumberTransfomer<Double>() {

        @Override
        public void transform(String source, Double target) {

        }
    };

    System.out.println(String.format("intTransformer: %s", intTransformer.getTransformerName()));
    System.out.println(String.format("longTransformer: %s", longTransformer.getTransformerName()));
    System.out.println(String.format("stringTransformer: %s", stringTransformer.getTransformerName()));
    System.out.println(String.format("doubleTransformer: %s", doubleTransformer.getTransformerName()));
}