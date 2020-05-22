static <T> int copy(
    DSLContext create, Table<?> table, Field<T> field, 
    T oldValue, T newValue
) {
    List<Field<?>> into = new ArrayList<>();
    List<Field<?>> from = new ArrayList<>();

    into.addAll(Stream.of(table.fields())
                      .filter(f -> !field.equals(f))
                      .collect(toList()));
    from.addAll(into);

    into.add(field);
    from.add(val(newValue));

    return
    create.insertInto(table)
          .columns(into)
          .select(
             select(from)
            .from(table)
            .where(field.eq(oldValue))
          .execute();
}