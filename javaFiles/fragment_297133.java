@Override
public synchronized Serializable generate(SessionImplementor session, Object object) throws HibernateException {
    Serializable result;
    if (object instanceof Route ) {
        Route reoute= ((Route ) object);
        if (route.getid() != null) {
            result = (Serializable) route.getId();
        } else {
            result = <GENERATE new ID(e.g. call super, etc)> ;
        }
        if (route.getRouteNumberId() == null) {
            long autoIncrRouteId = <GENERATE new routeID,>
            route.setRouteNumberId(autoIncrRouteId );
        }
        return result;
    } else {
        result = super.generate(session, object);
    }

    return result;
}