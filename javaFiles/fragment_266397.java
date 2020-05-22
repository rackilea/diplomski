@Test
public void reportsLostIfAuctionClosesWhenBidding() {
    sniper.currentPrice(123, 45, PriceSource.FromOtherBidder);
    sniper.auctionClosed();
    verify(sniperListenerSpy, atLeastOnce()).sniperLost();
    assertEquals(SniperState.bidding, sniperState);
}