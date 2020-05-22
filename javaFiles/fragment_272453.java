stack.add(letters[i]);
final String newMessage = message.substring(codes[i].length());
if (newMessage.equals("")) {
    gList.addAll(stack);
    gList.add("|");
    stack.pop();
    return;
}
CodesCheck(newMessage, letters, codes, stack);
stack.pop();