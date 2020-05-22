dashboardLink.addClickHandler( 
   new ClickHandler() 
   {
       public void onClick( ClickEvent event ) 
       {
           mainPanel.setWidget( getDashboardMenuContent() );
       }
   } );