Element root = textPane.getDocument().getDefaultRootElement();
int lines = root.getElementCount();

for (int i = 0; i < lines; i++)
{
    Element line = root.getElement( i ); 
    int start = line.getStartOffset();
    int end = line.getEndOffset();
    String text = document.getText(start, end - start);
    System.out.println(text);
}