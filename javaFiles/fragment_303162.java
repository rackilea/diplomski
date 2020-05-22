synchronized( Clients ) {
    for (Iterator<Bot> it = Clients.iterator(); it.hasNext();) {
        Bot bot = it.next();
        if (bot != null && bot.getLoader() != null && bot.getLoader() == loader) {
            it.remove();
            loader.destruct(); //Destroy my applet. Calls applet.stop() and then applet.destroy()
        }
    }
    }