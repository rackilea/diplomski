EventListener evl;

@AfterCompose
public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
    Selectors.wireComponents(view, this, false);
    exitButton.addEventListener("onClick", evl = new EventListener<Event>() {

        public void onEvent(Event evt) throws Exception {
            Messagebox.show("adddingggg");
        }
    });
}

@GlobalCommand
public void disable() {
    if(exitButton.removeEventListener("onClick", evl))
            Messagebox.show("success");
}