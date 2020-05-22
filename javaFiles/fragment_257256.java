if (isEmpty())
  return null;
else
{
  for (int i = 0; i < index; i++)
    tmpStack.push(this.pop());

  E removedElement = tmpStack.pop();

  while (!tmpStack.isEmpty())
    this.push(tmpStack.pop());

  return removedElement;
}