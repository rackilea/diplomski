@Query(
    "SELECT"
    "   f.id,"
    "   CASE WHEN f.bar IS NOT NULL THEN TRUE ELSE FALSE END AS bar"
    " FROM Foo f"
)
List<FooProjection> findProjections();