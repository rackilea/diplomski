public class Main {

    public static void main(String[] args) {
        try {
            IEventDesignDialog a  = ((IEventDesignDialog)getInstance(EventDesignDialog.class)).getEventType().getShow();

            ((IShowDesignDialog)getInstance(ShowDesignDialog.class)).getShowName().getShowType();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static <T extends IPage> T getInstance(final Class<? extends IPage> type) throws InstantiationException, IllegalAccessException {
        return (T) IPageProxy.getInstance(type);
    }

}