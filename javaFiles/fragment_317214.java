@Page(path = "MyPath")
public interface IEventDesignDialog extends IPage{
    @Entity(visibileName = "Show")
    public IEventDesignDialog getShow();

    @Entity(visibileName = "Date And Time display format")
    public IEventDesignDialog getDateAndTimeDisplayFormat();

    @Entity(visibileName = "Event Type")
    public IEventDesignDialog getEventType();    
}