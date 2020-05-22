/**
 * Add a new node containing the input Magazine to the front of the linked list.
 *
 * @param mag A magazine to put at the head of the list.
 */
public void add (Magazine mag){
    MagazineNode node = new MagazineNode(mag);
    node.next = list;
    list = node;
}