tradeLog.setTradeId("1");

//Create MapSqlParameterSource based on tradeLog
MapSqlParameterSource param = new MapSqlParameterSource();
for(Field field :  TradeLog.class.getDeclaredFields()) {
    Column column =   field.getAnnotation(Column.class);

    if(column != null) {
        field.setAccessible(true);
        param.addValue(column.name(), field.get(tradeLog));     
    }
}

insertProc.execute(param)