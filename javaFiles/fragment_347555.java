public class SearchDAO {
    private List<DriverSearchResult> resultList = new ArrayList<>();


    public boolean searchDriver(Searching searching) {
        try {
            // ...
            if(rs.next()) {
                DriverSearchResult setResult = new DriverSearchResult();
                // ...
                resultList.add(setResult); // <<<<<<<<<
                return true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public List<DriverSearchResult> getDriverResult(){
        return resultList; // <<<<
    }
}