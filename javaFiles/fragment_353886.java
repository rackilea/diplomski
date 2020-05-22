webView.getEngine().setOnAlert( ( event ) -> {
   Alert alert = new Alert( AlertType.INFORMATION );
   alert.setTitle( "Webpage says" );
   alert.setContentText( event.getData() );
   alert.showAndWait();
});
webView.getEngine().executeScript( "alert('Mea')" );