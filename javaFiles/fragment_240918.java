private static ChatRoomClientGUI singleton;
...
public ChatRoomClientGUI() {
    singleton = this;
    ...
}

private static void handleInputStream(){
    String response = input.nextLine();
    singleton.textAreaMessages.append(response + "\n");
}