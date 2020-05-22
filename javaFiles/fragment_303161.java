public static Bot remove(int hashCode) {
   synchronized( Clients ) {
    for (Iterator<Bot> it = Clients.iterator(); it.hasNext();) {
        Bot bot = it.next();
        if (bot.getCanvas().getClass().getClassLoader().hashCode() == hashCode) {
            it.remove();
            return bot;
        }
    }
    return null;
  }// synchronized
}