public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
            throws HibernateException
    {
        String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);
        Type type = criteriaQuery.getTypeUsingProjection(criteria, propertyName);
        StringBuffer fragment = new StringBuffer();
        for (int i = 0; i < columns.length; i++)
        {
            SessionFactoryImplementor factory = criteriaQuery.getFactory();
            fragment.append("customOrder");
            fragment.append("(");
            boolean lower = ignoreCase && type.sqlTypes(factory)[i] == Types.VARCHAR;
            if (lower)
            {
                fragment.append(factory.getDialect().getLowercaseFunction())
                        .append('(');
            }
            fragment.append(columns[i]);
            if (lower)
                fragment.append(')');
            fragment.append(")");
            fragment.append(ascending ? " asc" : " desc");
            if (i < columns.length - 1)
                fragment.append(", ");
        }
        return fragment.toString();
    }