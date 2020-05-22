package org.hibernate.criterion;

import org.hibernate.dialect.Dialect;

public class IlikeExpression extends LikeExpression {

    protected IlikeExpression(
            String propertyName,
            Object value) {
        super(propertyName, value);
    }

    protected IlikeExpression(
            String propertyName,
            String value,
            MatchMode matchMode) {
        super(propertyName, value, matchMode);

    }

    protected IlikeExpression(
            String propertyName,
            String value,
            Character escapeChar) {
        super(propertyName, value, escapeChar);
    }

    @Override
    protected String lhs(Dialect dialect, String column) {
        return dialect.getLowercaseFunction() + '(' + column + ')';
    }

    @Override
    protected String typedValue(String value) {
        return super.typedValue(value).toLowerCase();
    }

}