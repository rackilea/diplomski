public class ScrollPanelDemo implements EntryPoint {
   public void onModuleLoad() {
      FormPanelExample formPanelExample = new FormPanelExample();

      ScrollPanel scrollPanel = new ScrollPanel(formPanelExample);
      scrollPanel.setSize("500px", "200px");

      RootPanel.get().add(scrollPanel);
   }  
}