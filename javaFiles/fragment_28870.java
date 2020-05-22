InputStream afmStream = ResourceLoader.loadResource("org/apache/pdfbox/resources/afm/Helvetica.afm");
AFMParser afmParser = new AFMParser(afmStream);
afmParser.parse();
FontMetric afmMetrics = afmParser.getResult();
List<Float> newWidths = new ArrayList<Float>();
for (CharMetric charMetric : afmMetrics.getCharMetrics())
{
    if (charMetric.getCharacterCode() < 0)
        continue;
    while (charMetric.getCharacterCode() >= newWidths.size())
        newWidths.add(0f);
    newWidths.set(charMetric.getCharacterCode(), charMetric.getWx());
}
font.setFirstChar(0);
font.setLastChar(newWidths.size() - 1);
font.setWidths(newWidths);