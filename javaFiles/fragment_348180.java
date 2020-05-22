if (head != null) {
    while ((current != null) && (!found)) {
        // check to see if you have the right value, set `found` if you do
        // otherwise, continue
        if (!found) { // do this otherwise you'll return the next value everytime
            current = current.getNext();
        }
    }
    if (!found) { // if you're at the end of the list and you didn't find the value
        // set current = to something you want to return if the value was not found
    }

}
return current;