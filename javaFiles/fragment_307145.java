/**
 * This will import and copy the contents from another location. Currently the content stream is stored in a scratch
 * file. The scratch file is associated with the document. If you are adding a page to this document from another
 * document and want to copy the contents to this document's scratch file then use this method otherwise just use
 * the {@link #addPage} method.
 * 
 * Unlike {@link #addPage}, this method does a deep copy. If your page has annotations, and if
 * these link to pages not in the target document, then the target document might become huge.
 * What you need to do is to delete page references of such annotations. See
 * <a href="http://stackoverflow.com/a/35477351/535646">here</a> for how to do this.
 *
 * @param page The page to import.
 * @return The page that was imported.
 * 
 * @throws IOException If there is an error copying the page.
 */
public PDPage importPage(PDPage page) throws IOException