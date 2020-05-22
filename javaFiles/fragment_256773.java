public String logging( String logs )
{
//log.debug("................C Logging request..................");
if (logs.endsWith("\n"))
    logs = logs.substring(0, logs.length() - 1);
log.info("From C: " + logs);
return "SUCCESS";
}