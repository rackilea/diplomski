public class Pagination<T> {

    private static final int MAX_PAGE_LENGTH = 20;
    private static final int MAX_PAGES = 5;

    private int currentPage;
    private List<T> list;

    public Pagination(List<T> list, String currentPage){
        this.list = list;

        if (currentPage == null)
            this.currentPage = 1;
        else
            this.currentPage = Integer.parseInt(currentPage);
    }

    public List<T> getPagedList() throws Exception {
        if (currentPage * MAX_PAGE_LENGTH + MAX_PAGE_LENGTH > list.size()){
            return list.subList(currentPage * MAX_PAGE_LENGTH, list.size());
        }
        return list.subList(currentPage * MAX_PAGE_LENGTH, currentPage * MAX_PAGE_LENGTH + MAX_PAGE_LENGTH);
    }
}