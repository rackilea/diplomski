public class Service : IService
{
    private IOtherService otherService;

    public Service(IDep1 dep1, IDep2 dep2, IDep3 dep3) {
        this.otherService = new OtherService(dep1, dep2, dep3);
    } 
}