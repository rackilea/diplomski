private class SniperListenerStub implements SniperListener {
    @Override
    public void sniperLost() {
    }

    @Override
    public void sniperBidding() {
        sniperState = SniperState.bidding;
    }

    @Override
    public void sniperWinning() {
    }
}