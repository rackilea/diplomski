F.Promise<Integer> one, two;
one = F.Promise.promise(new F.Function0<Integer>() {
    @Override public Integer apply() throws Throwable {
        return 20;
    }
});
two = F.Promise.promise(new F.Function0<Integer>() {
    @Override public Integer apply() throws Throwable {
        return 22;
    }
});
return F.Promise.sequence(one, two).map(new F.Function<List<Integer>, Result>() {
    @Override
    public Result apply(List<Integer> integers) throws Throwable {
        int res = integers.get(0) + integers.get(1);
        return ok("The answer is " + res);
    }
});