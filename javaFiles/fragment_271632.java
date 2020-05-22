public class FilterByIdForUserSpecification<AL extends AbstractActivityLogWithSiteUser> implements Specification<AL>
{
private final Sort.Direction direction;
private final Specification<AL> specification;


public FilterByIdForUserSpecification(
        final Specification<AL> specification,
        final Sort.Direction direction )
{
    this.specification = specification;
    this.direction = direction;
}

@Override
public Predicate toPredicate(
        final Root<AL> root,
        final CriteriaQuery<?> query,
        final CriteriaBuilder cb )
{
    Path<Object> siteUser = root.get( AbstractActivityLogWithSiteUser.Index.USER );
    Path<Object> ownerOrg = siteUser.get( SiteUser.Index.PRI_ORG ).get( Organization.Index.OWNER );
    Path<Object> fullName = siteUser.get( SiteUser.Index.CONTACT ).get( Contact.Index.FULL_NAME );
    Path<Object> roleDisp = siteUser.get( SiteUser.Index.ROLE ).get( Role.Index.DISPLAY );

    Expression<Object> queryCase = cb.selectCase()
            .when( cb.equal( ownerOrg, true ), roleDisp )
            .otherwise( fullName );

    query.orderBy( direction( cb, queryCase, direction ) );
    return specification.toPredicate( root, query, cb );
}

static Order direction( final CriteriaBuilder cb, final Expression<?> e, final Sort.Direction direction )
{
    if ( direction == Direction.ASC )
    {
        return cb.asc( e );
    }
    return cb.desc( e );
}
}