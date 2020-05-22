//don't print head, since that seems to be empty in your implementation.
//also make sure head does not reference `null` by accident...
if (curr.next == null)
    return result;
curr = curr.next;

//1st element after `head`
result += curr.data;

while (curr.next != null) {
    curr = curr.next;
    result += ", " + curr.data;
}