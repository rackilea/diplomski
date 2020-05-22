public class ClassInExpression extends InExpression {
    private static final String CLASS = "class";
    private final Collection<Class> values;

    public ClassInExpression(Collection<Class> values) {
        super(CLASS, values.toArray(new Object[values.size()]));
        this.values = values;
    }

    @Override
    public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) {
        if (criteriaQuery.getTypeUsingProjection(criteria, CLASS).isComponentType()) {
            return super.getTypedValues(criteria, criteriaQuery);
        }
        return convertToDiscriminatorValues(criteria, criteriaQuery);
    }

    private TypedValue[] convertToDiscriminatorValues(Criteria criteria, CriteriaQuery criteriaQuery) {
        List<TypedValue> resultList = new ArrayList<TypedValue>();
        for (Object value : values) {
            resultList.add(criteriaQuery.getTypedValue(criteria, CLASS, value));
        }
        return resultList.toArray(new TypedValue[resultList.size()]);
    }
}