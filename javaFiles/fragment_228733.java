public static void sayHelloToEveryone() {
    String msg = "Hello <playername>!";
    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        p.sendMessage(msg.replaceAll("<playername>", p.getName()));
    }
}