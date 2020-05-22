ChangeListener listener;
if (!slider_Vol.getChangeListeners().length == 0){
    listener = slider_Vol.getChangeListeners()[0]
    slider_Vol.removeChangeListener(slider_Vol.getChangeListeners()[0]);
} else {
    listener = new ChangeListener[your code];
}
slider_Vol.addChangeListener(listener);