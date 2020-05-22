public class Service : IService
{
    private IOtherService otherService;

    public Service(IOtherService otherService) {
        this.otherService = otherService;
    } 
}