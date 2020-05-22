// load PDF document
PDFDocument document = new PDFDocument();
document.load(new File("input.pdf"));

// create renderer
SimpleRenderer renderer = new SimpleRenderer();

// set resolution (in DPI)
renderer.setResolution(300);

// render
List<Image> images = renderer.render(document);