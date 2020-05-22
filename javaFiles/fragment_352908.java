UI popUp, mainUI;
popUp = UI.getCurrent();
JavaScript.eval("close()");
popUp.close(); 

VaadinSession session = getSession();
mainUI = session.getUIById(mainUIId);
UI.setCurrent(mainUI);