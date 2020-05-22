LinearNode<Integer> current = head;

while(current != null)
{
    System.out.println(current.getElement());
    current = current.getNext();
}