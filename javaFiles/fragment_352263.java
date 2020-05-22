public static Node reverse(Node curr, Node ogHead) {
    // base case if we end up back at the head of the original list return
    // our new list

    if (curr == ogHead) {
        return ogHead;
    }

    Node oldOgHead = ogHead.link; // Remember what is behind (the original) ogHead
    Node nextCurr = curr.link; // Remember curr's successor (which is the starting point for the next recursion)

    // Move/insert curr right after ogHead
    ogHead.link = curr; // Put curr after ogHead
    curr.link = oldOgHead; // Whatever was after ogHead, put it after curr

    curr = nextCurr; // Prepare for next recursion

    if (curr != null) {
        reverse(curr, ogHead);
    }

    return ogHead;
}