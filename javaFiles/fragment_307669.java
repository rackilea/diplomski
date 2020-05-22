LOGGER.info("Invalidating previous session for agent: " + agentId);
String sessionId = null;
if (cacheService.getValue(agentId + "_session") != null)
  sessionId = (String) cacheService.getValue(agentId + "_session");
cacheService.deleteValue(agentId + "_session");
cacheService.deleteValue(sessionId + "_session");
if (cacheService.getValue(sessionId) != null) {
  LOGGER.info("Session invalidated from redis for agent: " + agentId);
  cacheService.deleteValue(sessionId);
} else {
  LOGGER.info("Agent session not found in redis sessions for agent: " + agentId);
}