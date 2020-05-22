Vector toRemove=new Vector();
Iterator<Player> iterator = plugin.inreview.keySet().iterator();
while (iterator.hasNext()) {
  Player key = (Player) iterator.next();
  toRemove.add(key);
}
chat.getRecipients().removeAll(toRemove);