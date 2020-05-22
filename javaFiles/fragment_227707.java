Node prev;

while((line = reader.readLine()) != null) 
{
    word = line;
    node = new Node(word);
    node.next = null;

    if(head == null) {
        head = node;
    } 

    if(prev != null) {
        prev.next = node;
    }
    prev = node;

}