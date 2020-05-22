private ContentPanel contentPanel;

public SwapScreen() {
 contentPanel = new ContentPanel();
 add(contentPanel);
}

public void swap1() {

   /*This should be split into a separate
    method and called only once to avoid recreating them.*/
   field1 = new TextField<String>();
   contentPanel.add(field1);

   field2 = new TextField<String>();
   contentPanel.add(field2);

  this.layout(true);
}

public void swap2() {

   /*This should be split into a separate
    method and called only once to avoid recreating them.*/
   anotherField1 = new TextField<String>();
   contentPanel.add(anotherField1);

   anotherField2 = new TextField<String>();
   contentPanel.add(anotherField2);

   this.layout(true);
}