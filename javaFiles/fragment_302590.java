public class AppleStateMachine extends ListenerAdapter {
    private final long channelId, authorId; // id because keeping the entity would risk cache to become outdated

    public AppleStateMachine(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // don't respond to other bots
        if (event.getChannel().getIdLong() != channelId) return; // ignore other channels
        MessageChannel channel = event.getChannel();
        String content = event.getMessage().getContentRaw();
        // since only one state is present you don't need a switch but that would be the concept if you had more than 1 interaction point in this protocol
        if (content.equals("Stop")) {
            channel.sendMessage("Understood!").queue();
            event.getJDA().removeEventListener(this); // stop listening
        }
        else if (event.getAuthor().getIdLong() == authorId) {
            channel.sendMessage("Hi " + content + "!").queue();
            event.getJDA().removeEventListener(this); // stop listening
        }
        else {
            channel.sendMessage("Wait your turn " + event.getMember().getEffectiveName() + "!").queue();
        }
    }
}