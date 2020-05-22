private static String cachedToken = null;

public static getAuthTicket()  {
  if (cachedToken == null || isTooOld(cachedToken)) {
    cachedToken = getAuthTicketForReal();
  }
  return cachedToken;
}