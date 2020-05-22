@EventHandler
public void onPlayerChat(ChannelChatEvent event) {
    ChannelManager cm = Herochat.getChannelManager();
    String newFormat;
    Player player = event.getSender().getPlayer();
    String chatReplacement = plugin.classWithReplacer.replacer(player);

    // Simple replacement here. If it is equal to "", let it replace as
    // normal. If it actually has a value, surround it with brackets.
    if (!chatTitle.equalsIgnoreCase("")) {
        chatTitle = "[" + chatTitle + "]";
    }

    // When the channel being spoken in uses the default format,
    // asking it for the format returns "{format}"
    //
    // We do not need to escape the brackets because
    // String.equalsIgnoreCase does not use regex.
    if (event.getFormat().equalsIgnoreCase("{default}")) {
        // cm.getStandardFormat() returns the format provided in config.yml
        newFormat = cm.getStandardFormat();

        // IMPORTANT!! You MUST escape the curly brackets or your plugin WILL throw regex errors!
        // We escape with two backslashes because the java parser takes one away, resulting in \{ and \} respectively.
        // Then, the regex parser comes in and converts \{ into a safe {, and \} into a safe }
        // "your_replacement_here" should be whatever your custom tag is within the config.yml or the channel's config file.
        // In my case, this was {title}.
        // Note: the square brackets can be added to your config file, but I chose to add them here to avoid empty brackets
        // when the player did not have a title.
        newFormat = newFormat.replaceAll("\\{your_replacement_here\\}", chatReplacement);
    } else {
        // event.getFormat() returns the current channel's format or "{default}"
        newFormat = event.getFormat();
        newFormat = newFormat.replaceAll("\\{your_replacement_here\\}", chatReplacement);
    }

    // This method performs a "one-time" change to the default format.
    // Because you are providing the same format as the original, only
    // contextually modified for the player or player's group, the chat
    // output will still be determined by the global or channel config
    event.setFormat(newFormat);
}