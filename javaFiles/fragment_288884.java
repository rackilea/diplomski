public interface MonthAndCount {
    Integer getMonth();
    Long getCount();
}

@Query("select month(s.dateCompleted) as month, count(s.id) as count from Shipment s where year(s.dateCompleted) = ?1 group by month(s.dateCompleted)")
List<MonthAndCount> getMonthAndCount(int year);