public class LiteralExpression<T> extends ExpressionImpl<T> {

    private final String literal;

    private LiteralExpression(String literal, CriteriaBuilderImpl cb, Class<T> clazz) {
        super(cb, clazz);
        this.literal = literal;
    }

    @Override
    public void registerParameters(ParameterRegistry registry) {
    }

    @Override
    public String render(RenderingContext renderingContext) {
        return literal;
    }

    @Override
    public String renderProjection(RenderingContext renderingContext) {
        return null;
    }

    public static <T> LiteralExpression<T> of(String literal, CriteriaBuilder cb, Class<T> clazz) {
        return new LiteralExpression<>(literal, (CriteriaBuilderImpl) cb, clazz);
    }
}