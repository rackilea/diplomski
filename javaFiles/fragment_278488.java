@Inject
EPartService partService;


// Create the part

MPart part = partService.createPart("editor id");

// Set the input

part.getTransientData().put("input key", inputData);

// Add to editor part stack

MPartStack editorStack = ... find your part stack for the editor

editorStack.getChildren().add(part);

// Show

partService.showPart(part, PartState.ACTIVATE);