import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class HibernateCallbackImpl 
    implements HibernateCallback<List<T>> {

    private String queryString;
    private String[] paramNames;
    private Object[] values;

    private int firstResult;
    private int maxResults;

    /**
     * Fetches a {@link List} of entities from the database using pagination.
     * Execute HQL query, binding a number of values to ":" named parameters in the query string.
     * 
     * @param queryString a query expressed in Hibernate's query language
     * @param paramNames the names of the parameters
     * @param values the values of the parameters 
     * @param firstResult a row number, numbered from 0
     * @param maxResults the maximum number of rows
     */
    public HibernateCallbackImpl(
            String queryString, 
            String[] paramNames, 
            Object[] values,
            int firstResult,
            int maxResults) {
        this.queryString = queryString;
        this.paramNames = paramNames;
        this.values = values;

        this.firstResult = firstResult;
        this.maxResults = maxResults;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException,
            SQLException {
        Query query = session.createQuery(queryString);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);

        // TODO: throw proper exception when paramNames.length != values.length

        for (int c=0; c<paramNames.length; c++) {
            applyNamedParameterToQuery(query, paramNames[c], values[c]);
        }

        @SuppressWarnings("unchecked")
        List<T> result = query.list();

        return result;
    }


     /**
     * Code borrowed from org.springframework.orm.hibernate3.HibernateTemplate.applyNamedParameterToQuery(Query, String, Object)
     * 
     * Apply the given name parameter to the given Query object.
     * @param queryObject the Query object
     * @param paramName the name of the parameter
     * @param value the value of the parameter
     * @throws HibernateException if thrown by the Query object
     */
    protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value)
            throws HibernateException {

        if (value instanceof Collection) {
            queryObject.setParameterList(paramName, (Collection) value);
        }
        else if (value instanceof Object[]) {
            queryObject.setParameterList(paramName, (Object[]) value);
        }
        else {
            queryObject.setParameter(paramName, value);
        }
    }

}