private VerticalLayout  getResultLayout() {


VerticalLayout resultLayout = new VerticalLayout();
VerticalLayout .setWidth("1380px");
resultLayout.setStyleName("mwiWorksResultLayout");
resultLayout.setSizeUndefined();
for (int i = 0; i < 200; i++) {
    Label l = new Label("test horizontal scrollbar right side not 
   shown totaly     
  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

   aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

     aaaaaaaaaaaaaaaaaaaaaaaaaattttttttttttttttttttttttttttttttttttttttttttttttttt

tttttttttttttttttttttttttXXXXXXXXXXXX");
    resultLayout.addComponent(l);
                                 }

return resultLayout;

 }