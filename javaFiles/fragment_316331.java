String msg = exchange.getIn().getBody(String.class);

log.info("Message before apply filter: " + msg);
filteredMessage = msg.replaceAll("[^\\x00-\\x7F]","");
log.info("Remove non-ASCII characters: " + filteredMessage);
filteredMessage =filteredMessage.replaceAll("[\\p{C}]","");
log.info("Remove all Control characters: " + filteredMessage);
filteredMessage = filteredMessage.replaceAll("[\\p{Cntrl}\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]","");
log.info("Remove some Control characters: " + filteredMessage);
filteredMessage = filteredMessage.replaceAll("[^\\p{Print}]","");
log.info("Remove non printable characters: " + filteredMessage);
filteredMessage = filteredMessage.trim();
log.info("Trim: " + filteredMessage);
filteredMessage = filteredMessage.replaceAll("\\cM","");
log.info("Remove ^M Control characters: " + filteredMessage);
filteredMessage = filteredMessage.replaceAll("^M","");
log.info("Remove ^M Control characters: " + filteredMessage);