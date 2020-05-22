SQLQuery query = session.createSQLQuery("Select c.id, TIME_FORMAT(c.concert_time, '%H:%i'), c.band_id, "
                + "b.name, b.band_type, b.set_length, b.encore, b.relevance from Concert c left join Band b on b.id = c.band_id "
                + "where c.stage_id = :id");

        query.setParameter("id", id);       
        List<Object[]> rows = query.list();
        List<Concert> concertList = new ArrayList<Concert>();