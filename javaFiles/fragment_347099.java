String sql = "INSERT INTO campaign_table (`account_id` ,`brand_id` ,`platform_id` ,`campaign_id` ,`Blended KPI 85/10/5` ,`CPB (85/10/5)`) VALUES (:account_id, :brand_id, :platform_id, :campaign_id, :Blended_KPI_85_10_5 , :CPB_85_10_5)"

Map[] params = dailyRecords.stream().map(m -> {
    m.put("Blended_KPI_85_10_5", m.get("Blended_KPI_85/10/5"));
    m.put("CPB_85_10_5", m.get("CPB_(85/10/5)"));
    return m;
}).toArray(Map[]::new);

namedParameterJdbcTemplate.batchUpdate(sql, params);