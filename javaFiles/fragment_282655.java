public String toString ()
{
    return "Company name: " + nextTicket.getCompanyName() + " Symbol: " + nextTicket.getCompanySymbol() + " Currency: " + nextTicket.getCurrency()
          + " Available shares: " + getAvailableShares() + " Value per share: " + getValuePerShare()
          + " DateOLU: " + getDateOLU();
}