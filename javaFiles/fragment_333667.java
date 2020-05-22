while( (currentLine = myReader.readLine()) != null)
{
  if(pLine.contains(currentLine))
  {
    return false;
  }
}