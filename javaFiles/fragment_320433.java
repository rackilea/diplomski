public class Factory
{
    @Autowired
    private List<? extends Handler> handlerList; 

    public <T extends Handler> T createHandler(Class<T> type) {
        for(Handler handler : handlerList) {
            if (type.getSimpleName().equals(handler.getClass().getSimpleName()) {
                return handler;
            }
        }

        return ...; //some default value
    }
}