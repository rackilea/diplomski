PircBot bot = new PircBot();
bot.setName("user");
bot.setVerbose(true);
bot.connect("irc.twitch.tv", 6667, "oauth:code");
bot.joinChannel("#channel");
bot.sendMessage(target, message);