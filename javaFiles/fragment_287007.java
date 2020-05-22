public class OrExample extends org.hibernate.criterion.Example {

    @Override
    protected void appendPropertyCondition(
        String propertyName,
        Object propertyValue,
        Criteria criteria,
        CriteriaQuery cq,
        StringBuffer buf)
    throws HibernateException {
        Criterion crit;
        if ( propertyValue!=null ) {
            boolean isString = propertyValue instanceof String;
            if ( isLikeEnabled && isString ) {
                crit = new LikeExpression(
                        propertyName,
                        ( String ) propertyValue,
                        matchMode,
                        escapeCharacter,
                        isIgnoreCaseEnabled
                );
            }
            else {
                crit = new SimpleExpression( propertyName, propertyValue, "=", isIgnoreCaseEnabled && isString );
            }
        }
        else {
            crit = new NullExpression(propertyName);
        }
        String critCondition = crit.toSqlString(criteria, cq);
        if ( buf.length()>1 && critCondition.trim().length()>0 ) buf.append(" or ");
        buf.append(critCondition);
    }