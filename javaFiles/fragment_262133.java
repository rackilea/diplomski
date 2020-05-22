public B getB(
    String bUuid,
    Supplier<? extends Collection<? extends Field<?>>> select,
    Supplier<? extends Collection<? extends Table<?>>> from,
    Supplier<? extends Collection<? extends Condition>> where
) {
    List<Field<?>> allSelect = new ArrayList<>();
    allSelect.addAll(/* general B columns */);
    allSelect.addAll(select.get());

    List<Table<?>> allFrom = new ArrayList<>();
    allFrom.addAll(/* general B tables */);
    allFrom.addAll(from.get());

    List<Table<?>> allWhere = new ArrayList<>();
    allWhere.addAll(/* general B conditions*/);
    allWhere.addAll(where.get());

    dsl.select(allSelect)
       .from(allFrom)
       .where(allWhere);
}