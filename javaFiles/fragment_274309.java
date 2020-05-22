if (Desktop.isDesktopSupported()) {
   desktop = Desktop.getDesktop();
   // blah blah
} else {
   // try to launch xdg-open
   // or try launching other browsers?
}