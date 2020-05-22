public static final String orderClause = " order by "
            + "case when :orderField = 'id' and :orderDirection = 'asc' then s.id else 0 end ASC, "
            + "case when :orderField = 'id' and :orderDirection = 'desc' then s.id else 0 end DESC, "
            + "case when :orderField = 'username' and :orderDirection = 'asc' then s.username else '' end ASC, "
            + "case when :orderField = 'username' and :orderDirection = 'desc' then s.username else '' end DESC, "
            + "s.id ASC";