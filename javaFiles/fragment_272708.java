static void sendMessage(User user, String content) {
    user.openPrivateChannel().queue(channel -> { // this is a lambda expression
        // the channel is the successful response
        channel.sendMessage(content).queue();
    });
}

guild.getMembers().stream()
    .map(Member::getUser)
    .forEach(user -> sendMessage(user, "ZDAROVA"));