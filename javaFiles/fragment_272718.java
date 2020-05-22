package org.jooq.impl
public abstract class Projection<R extends Record> extends TableImpl<R> {

  public static final <R extends Record, T> TableField<R, T> newField(String name, DataType<T> type, Table<R> table) {
    return newField(name, type, table, null, null, null);
  }
  public static final <R extends Record, T, X, U> TableField<R, U> newField(String name, DataType<T> type, Table<R> table, String comment, Converter<X, U> converter, Binding<T, X> binding) {
    final Binding<T, U> actualBinding = DefaultBinding.newBinding(converter, type, binding);
    @SuppressWarnings("unchecked")
    final DataType<U> actualType =
        converter == null && binding == null
      ? (DataType<U>) type
      : type.asConvertedDataType(actualBinding);

    final TableFieldImpl<R, U> tableField = new TableFieldImpl<R, U>(name, actualType, table, comment, actualBinding);

   return tableField;
  }

  protected Projection(String name) {
    this(name, null);
  }
  protected Projection(String name, Table<R> aliased) {
    super(name, null, aliased);
  }

  protected <T> TableField<R,T> field(String name, DataType<T> type) {
    return newField(name, type, this);
  }
  protected <T,F extends Field<T>> F add(F field) {
    fields0().add(field);
    return field;
  }
  protected Fields<R> getFields() {
    return fields0();
  }
}