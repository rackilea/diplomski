// I use a AjaxButton to perform the user submit if you don't 
 // want use it, you should reload the entire page
 @Override
 protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
     //redraw the parent of the list view 
     target.add(theContainerOfTheListView);
     //the submited model of the dropdown
     ListViewModel item = form.getObject();                
     List<ListViewModel> list = listViewObject.getObject();
     list.add(item);
     //you could sort the list object in order to sort the listViewObject
 }