final Timer.Context context = timer.time();//1
try {
    String userOneName = userOne.get();
    String userTwoName = userTwo.get();
    return new ChatroomView(userOneName, userTwoName, chats.chatBetween(userOneName, userTwoName),
        chats.belongingTo(userOneName)
            .stream()
            .map(c -> new ChatView(userOneName, c))
            .collect(toList()));
} finally {
    context.stop();//2
}