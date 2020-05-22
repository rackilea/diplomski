Window windows[] = Window.getWindows();
for (Window w) {
  if (w.isFocused()) {
     ...
  }
  else if(w.isActive()) {
     ...
  }
}