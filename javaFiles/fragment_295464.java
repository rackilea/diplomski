public class ExtendedEditorKit extends HTMLEditorKit
{
    @Override
    public Document createDefaultDocument()
    {
        // For the left out code copy what's in the super method
        ..
        HTMLDocument doc = new ExtendedHTMLDocument(ss);
        ..
    }
}