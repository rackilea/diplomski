IEclipseContext serviceContext = E4Workbench
                        .getServiceContext();
                final IEclipseContext appContext = (IEclipseContext) serviceContext
                        .getActiveChild(); 

                EModelService modelService = appContext
                        .get(EModelService.class);
                MApplication app = serviceContext.get(MApplication.class);
                EPartService partService = serviceContext
                        .get(EPartService.class);
                MPartStack stack = (MPartStack) modelService.find(
                        "partstack.2", app);
                MPart part = modelService.createModelElement(MPart.class);
                part.setElementId("viewID");
                part.setContributionURI("bundleclass://org.eclipse.ui.workbench/org.eclipse.ui.internal.e4.compatibility.CompatibilityView");
                part.setCloseable(true);
                part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);

                stack.getChildren().add(part); // Add part to stack
                MPart viewPart = partService.showPart(part,
                        PartState.ACTIVATE); // Show part
                ViewReference ref = ((WorkbenchPage) PlatformUI
                        .getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage()).getViewReference(part);
                IViewPart viewRef = ref.getView(true);