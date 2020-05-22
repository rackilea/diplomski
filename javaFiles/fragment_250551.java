public class GameEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        ExporterUtil.exportAll();
        GWT.create(RoadServer.class); //forcing to export road server
    }

}