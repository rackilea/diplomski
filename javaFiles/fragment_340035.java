Document fichero = (Document) builder.build( xmlFile );
Element rootNode = fichero.getRootElement();
List<Element> toProcess = rootNode.getChildren( "fichada" );

for (Element tabla : toProcess) {
    .....
}
// remove all processed nodes from the in-memory document.
toProcess.clear();

// write the modified document back to disk.
....