public void assertCanBeWrittenAndReaback(List<FigureGeneral> inputFigure) {
  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
  absFigure.write(outStream, inputFigures);
  List<FigureGeneral> outputFigure = absFigure.figureReader(new ByteArrayInputStream(outStream.toByteArray()));
  assertEqualsFigureGeneralLists(inputFigure, outputFigure);
}