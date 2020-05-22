using(t)
    .insertInto(T2, T2.T2_FIELD)
    .select(
        select(
            T1.T1_FIELD.coerce(T2.T2_FIELD)
        )
        .from(T1)
    )
    .execute();