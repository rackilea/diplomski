srpJdbcTemplate.update(insertQuery, new Object[] {
    null, broadSoftResponse.getTransType(), broadSoftResponse.getRequestXml(),
    broadSoftResponse.getResponseXml(), null, null, null, null, null,
    ApplicationConstants.SOURCE_SYSTEM, ApplicationConstants.SOURCE_SYSTEM_ID,
    broadSoftResponse.getTrackingId(), null
}, new int[] {
    Types.INTEGER, Types.INTEGER, Types.VARCHAR,
    Types.VARCHAR, Types.DATE, Types.DATE, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
    Types.VARCHAR, Types.INTEGER,
    Types.INTEGER, Types.VARCHAR
});