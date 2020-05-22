@Query(value = "SELECT *, distance(l.point, POINT((?2), (?3))) AS jdistance "
        + "FROM cars j, car_categories c, localizations l "
        + "WHERE (j.name LIKE %?1% "
        + "OR j.description LIKE %?1% "
        + "OR (j.car_category_id = c.id AND c.name LIKE %?1%)) "
        + "AND l.id = j.localization_id "
        + "HAVING jdistance < 10 "
        + "ORDER BY jdistance"
        , nativeQuery = true)
List<Car> getNearestCars(String text, double lat, double lon);