for (Node current = firstL, int min = current.data;
     current != null;
     current = current.next)
{
    min = Math.min(min, current.data);
}