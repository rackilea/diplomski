/**
 * Create a new PDPage content stream. If the appendContent parameter is set to
 * {@link AppendMode#APPEND}, you may want to use
 * {@link #PDPageContentStream(PDDocument, PDPage, PDPageContentStream.AppendMode, boolean, boolean)}
 * instead, with the fifth parameter set to true.
 *
 * @param document The document the page is part of.
 * @param sourcePage The page to write the contents to.
 * @param appendContent Indicates whether content will be overwritten, appended or prepended.
 * @param compress Tell if the content stream should compress the page contents.
 * @throws IOException If there is an error writing to the page contents.
 */
public PDPageContentStream(PDDocument document, PDPage sourcePage, AppendMode appendContent,
                           boolean compress) throws IOException