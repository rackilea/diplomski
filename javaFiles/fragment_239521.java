private ResultTransformer getResultsTransformer()
{
    ResultTransformer transformer = new AliasToBeanResultTransformer(
            MyResultBean.class) {
        @Override
        public Object transformTuple(Object[] values, String[] aliases)
        {
            MyResultBean row = new MyResultBean();
            for (int i = 0; i < aliases.length; i++)
            {
                row.set(aliases[i], values[i]);
            }
            return (row);
        }
    };
    return transformer;
}