public static void addUserToChannel(Channel channel, User user) {
    Guild guild = channel.getGuild();
    Member member = guild.getMember(user);
    channel.createPermissionOverride(member)
           .setAllow(Permission.VIEW_CHANNEL)
           .queue();
}