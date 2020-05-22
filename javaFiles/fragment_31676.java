EModelService modelService = ... model service

MApplication application = .... the application

MWindow window = (MWindow)modelService.find("main window id", application);

EPartService partService = window.getContext().get(EPartService.class);