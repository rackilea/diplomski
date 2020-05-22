List<Window> visibleWindows = new ArrayList<Window>();
for(Window w: Window.getWindows()){
    if(w.isShowing()){
        visibleWindows.add(w);
    }
}