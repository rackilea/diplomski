private static class ParenthesisException extends Throwable
{
    public ParenthesisException(){}
    public String strErrMsg()
    {
        return "ERROR: Every '(' needs a matching ')'";
    }
}