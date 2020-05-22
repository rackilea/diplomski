itemId = inputRow.next();
if (itemId.charAt(itemId.length() - 2) == 'X') {
    // Remember the end quote ------^

    itemId = itemId.substring(1, itemId.length() - 2);
    // Get rid of the quotes -^  and the X --------^
} 
else {
    itemId = itemId.substring(1, itemId.length() - 1);
    // Get rid of the quotes -^--------------------^
}

long newitemId = Long.parseLong(itemId);