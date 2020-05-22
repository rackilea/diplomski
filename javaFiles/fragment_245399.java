public class MarkerSimple implements EntryPoint {
    @Override
    public void onModuleLoad() {
        // Just this. 
        RootLayoutPanel.get().add(new GwtMaps());
    }
}