@NamedQueries(
{
    @NamedQuery(name = "SysRoles.findAll", query = "SELECT s FROM SysRoles s" + SysRoles.orderClause),
    @NamedQuery(name = "SysRoles.findByIsActive", query = "SELECT s FROM SysRoles s WHERE s.isActive = :isActive " + SysRoles.orderClause)
}) 
public class SysRoles implements Serializable {
    public static final String orderClause = " order by "
        + "case when :orderField = 'id' and :orderDirection = 'asc' then s.id else 0 end ASC, "
        + "case when :orderField = 'id' and :orderDirection = 'desc' then s.id else 0 end DESC, "
        + "case when :orderField = 'username' and :orderDirection = 'asc' then s.username else '' end ASC, "
        + "case when :orderField = 'username' and :orderDirection = 'desc' then s.username else '' end DESC, "
        + "case when :orderField = 'isActive' and :orderDirection = 'asc' then s.isActive else '' end ASC, "
        + "case when :orderField = 'isActive' and :orderDirection = 'desc' then s.isActive else '' end DESC, "
        + "s.id ASC";
 ...
}