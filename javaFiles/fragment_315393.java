InputTextView inputView = new InputTextView();
OutputTextView outputView = new OutputTextView();

TextModel model = new DefaultTextModel();
// Shared model!!
TextController inputController = new DefaultTextController(model, inputView);
TextController outputController = new DefaultTextController(model, outputView);