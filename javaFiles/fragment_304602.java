StringBuilder currentText = new StringBuilder();

@Override
public void characters(char[] ch, int start, int length)
{
   currentText.append(ch, start, length);
}