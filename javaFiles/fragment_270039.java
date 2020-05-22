if (loggedIn()) {            
   WebMarkupContainer loggedInContainer = new WebMarkupContainer("loggedIn");
   //## do something with the user
   User user = getUserSomeWhere();
   loggedInContainer.add(new UserSearchLink("userSearchLink"));
   add(loggedInContainer);
   add(WebMarkupContainer("loggedOut").setVisible(false));
} else {
   add(new WebMarkupContainer("loggedIn").setVisible(false));
   WebMarkupContainer loggedOutContainer = WebMarkupContainer("loggedOut");
   loggedOutContainer.add(new LoginLink() {...});
   add(loggedOutContainer);
}