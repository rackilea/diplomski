public static void setServerMOTD(final String motd) throws Exception {
    final Field field = MinecraftServer.class.getDeclaredField("motd");
    final Field server = CraftServer.class.getDeclaredField("console");
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    field.setAccessible(true);
    server.setAccessible(true);
    modifiersField.setInt(server, server.getModifiers() & ~Modifier.FINAL);
    MinecraftServer instance = (MinecraftServer) server.get(Bukkit.getServer());
    field.set(instance, motd);
}