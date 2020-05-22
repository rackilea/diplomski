package com.company.model.jooq;
public class MyProjectedTable extends MyProjection<Record> {
  public final TableField<Record, Integer> ID        = add(field("ID", SQLDataType.INTEGER));
  public final Field<Timestamp>            TS_CREATE = add(timestamp("CREATE"));
  public final Field<Timestamp>            TS_UPDATE = add(timestamp("UPDATE"));
  public final TableField<Record, String>  NAME      = add(field("NAME", SQLDataType.VARCHAR));
  public final Field<String>               LABEL     = add(trimmed("LABEL"));
  public final Field<String>               COMMENT   = add(joined("COMMENT", "COMMENT1", "COMMENT2", "COMMENT3"));
}