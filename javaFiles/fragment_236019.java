class ValidatorComposite<T> implements Validator<T> {
    List<Validator<T>> validators = new ArrayList<>();
    public void addValidator(Validator<T> add) { validators.add(add)); }

    public Result validate(T toValidate) {
        Result result = Result.OK;
        for (Validator<T> v : validators) {
            result = v.validate(toValidate);
            if (result != Result.OK) break;
        }
        return result;
    }
}