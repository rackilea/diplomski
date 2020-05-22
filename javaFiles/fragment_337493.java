@Dao
public interface SpendingDao {

    @Insert
    void insertAll(Spending... spendings);

    @Query("SELECT * FROM spending")
    LiveData<List<Spending>> findAll();

    @Query("SELECT calendarDate AS 'DateTime', count(uID) AS 'SpendingCount', sum(value)  AS 'SpendingSum' from spending GROUP BY date(datetime(calendarDate))")
    LiveData<List<DayInformation>> loadDayInformation();
}