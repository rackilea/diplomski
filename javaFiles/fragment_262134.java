getB(
    uuid,
    () -> Arrays.asList(A.COL1, A.COL2, A.COL3),
    () -> Arrays.asList(A),
    () -> Arrays.asList(A.B_ID.eq(B.ID), A.COL4.like("%ABC%"))
);