Expression<Integer> caseExp = cb.<Integer>selectCase()
    .when(
        cb.and(
            cb.equal(root.get(Entity_.imported), true),
            cb.notEqual(root.get(Entity_.status), 1)
        ),
        1
    )
    .otherwise(0);

order.add(0, cb.asc(caseExp));