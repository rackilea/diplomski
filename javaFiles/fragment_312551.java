for (NewsPlugin plugin : plugins) {
  Runnable task = () -> {
    List<Headline> news;
    try {
      news = plugin.call(); /* There's really no need for plugin to be `Callable` */
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    java.awt.EventQueue.invokeLater(this::updateHeadlines);
  };
  int period = plugin.getUpdateFrequency();
  executor.scheduleAtFixedRate(task, period, period, TimeUnit.MILLISECONDS);
}