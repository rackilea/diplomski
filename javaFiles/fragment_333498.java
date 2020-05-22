form.getBody().setLayout(new FillLayout()); //*

Composite tabParent = managedForm.getToolkit().createComposite(form.getBody());
tabParent.setLayout(new FillLayout());

FigureCanvas canvas = new FigureCanvas(tabParent);
//no layouting
canvas.setContents(diagramContents);