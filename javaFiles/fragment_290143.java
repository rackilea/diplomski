abstract class BaseRule implements Comparable<BaseRule>
{
    abstract int executionPrecedence();

    @Override
    public int compareTo(final BaseRule that)
    {
        return Integer.compare(this.executionPrecedence(), that.executionPrecedence());
    }
}

class RuleA extends BaseRule
{
    @Override
    int executionPrecedence() { return 0; }
}

class RuleB extends BaseRule
{
    @Override
    int executionPrecedence() { return 1; }
}