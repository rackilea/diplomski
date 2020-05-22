ResourceBundle rb = ResourceBundle.getBundle(
       "com.MyPackage.Properties", Locale.getDefault());

frameTitle = (rb.getString("MyFrame.Title")); //myFrame.setTitle("frameTitle");
trayTitle = (rb.getString("MyFrame.TrayTitle"));
exitTitle = (rb.getString("MyFrame.Exit"));
newInfoTitle = (rb.getString("MyFrame.NewInfo"));
sendTitle = (rb.getString("MyFrame.Send"));