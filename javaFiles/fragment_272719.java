package com.company.model.jooq;
public abstract class MyProjection<R extends Record> extends Projection<R> {
  /**
   * Unique version identifier for serialization.
   */
  private static final long serialVersionUID = 1L;

  protected Field<String> trimmed(String name) {
    return DSL.trim(newField(name, SQLDataType.VARCHAR, this)).as(name);
  }
  protected Field<String> joined(String name, String... names) {
    @SuppressWarnings("unchecked")
    Field<String>[] fields = new Field[names.length];
    for (int i = 0; i < names.length; i++) {
      fields[i] = newField(names[i], SQLDataType.VARCHAR, this);
    }
    return DSL.trim(DSL.concat(fields)).as(name);
  }
  protected Field<Timestamp> timestamp(String suffix) {
    return DSL.function("timestamp", SQLDataType.TIMESTAMP,
        newField("DT_" + suffix, SQLDataType.DATE, this),
        newField("TI_" + suffix, SQLDataType.TIME, this)
    ).as("TS_" + suffix);
  }

  protected MyProjection(String name) {
    super(name);
  }
  protected MyProjection(String name, Table<R> aliased) {
    super(name, aliased);
  }
}