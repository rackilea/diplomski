/**
 * @param p_startTime The date and time in ms
 * @param p_endTime The date and time in ms
 * @param p_session the session
 * @return Returns the latest valid rule for the specified date time
 * @throws IOException
 */
@SuppressWarnings("unchecked")
public static List<Track> loadAllTracksByDateRange(final long p_startTime,
        final long p_endTime, final Session p_session) throws IOException {


    // create the criteria
    final Criteria criteria = p_session.createCriteria(TrackItem.class);


    // set projection
    criteria.setProjection(Projections.distinct(Projections
            .property("track")));


    // add the restriction
    criteria.add(Restrictions.ge("itemTime", p_startTime));
    criteria.add(Restrictions.le("itemTime", p_endTime));


    return criteria.list();
}