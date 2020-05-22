// (c) 2008-2010 FURTHeR Project, Health Sciences IT, University of Utah<br>
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.PropertyProjection;

public class GroupByHavingProjection extends PropertyProjection
{
    private static final long serialVersionUID = -3316795021430206470L;

    private final Projection havingProjection;
    private final String groupByProperty;
    private String op;
    private Object value;

    public GroupByHavingProjection(final String groupByProperty, final Projection projection, final String op, final Object value)
    {
        super(groupByProperty, true);
        this.projection = projection;
        this.groupByProperty = groupByProperty;
        this.op = op;
        this.value = value;
    }
}