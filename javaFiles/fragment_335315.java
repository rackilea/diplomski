/**
 * Create a new PDPage content stream.
 *
 * @param document The document the page is part of.
 * @param sourcePage The page to write the contents to.
 * @param appendContent Indicates whether content will be overwritten, appended or prepended.
 * @param compress Tell if the content stream should compress the page contents.
 * @param resetContext Tell if the graphic context should be reset. This is only relevant when
 * the appendContent parameter is set to {@link AppendMode#APPEND}. You should use this when
 * appending to an existing stream, because the existing stream may have changed graphic
 * properties (e.g. scaling, rotation).
 * @throws IOException If there is an error writing to the page contents.
 */
public PDPageContentStream(PDDocument document, PDPage sourcePage, AppendMode appendContent,
                           boolean compress, boolean resetContext) throws IOException