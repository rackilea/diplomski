public class Rule extends ArrayList<Validator> implements Validator {

    public Rule(Validator<?> ... chain) {
        addAll(Arrays.asList(chain));
    }

    public Object validate(Object target) {
        CompositeResult result = new CompositeResult(size());
        for (Validator rule : this) {
            Result tempResult = rule.validate(value);
            if (!tempResult.isOk())
                result.put(rule, tempResult);
        }
        return result;
    }
}

public class CompositeResult extends HashMap<Validator, Result> implements
        Result {

    private Integer appliedCount;

    public CompositeResult(Integer appliedCount) {
        this.appliedCount = appliedCount;
    }

    @Override
    public boolean isOk() {
        boolean isOk = true;
        for (Result r : values()) {
            isOk = r.isOk();
            if (!isOk)
                break;
        }
        return isOk;
    }

    @Override
    public String getMessage() {
        return toString();
    }

    public Integer failCount() {
        return size();
    }

    public Integer passCount() {
        return appliedCount - size();
    }

}