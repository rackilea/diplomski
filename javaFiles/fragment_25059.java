/**
 * This class is used for adding content directly onto a specified {@link PdfCanvas}.
 * {@link Canvas} does not know the concept of a page, so it can't reflow to a 'next' {@link Canvas}.
 *
 * This class effectively acts as a bridge between the high-level <em>layout</em>
 * API and the low-level <em>kernel</em> API.
 */
public class Canvas extends RootElement<Canvas>