twitterStream.addRateLimitStatusListener( new RateLimitStatusListener() {
    @Override
    public void onRateLimitStatus( RateLimitStatusEvent event ) {
        System.out.println("Limit["+event.getRateLimitStatus().getLimit() + "], Remaining[" +event.getRateLimitStatus().getRemaining()+"]");
    }

    @Override
    public void onRateLimitReached( RateLimitStatusEvent event ) {
        System.out.println("Limit["+event.getRateLimitStatus().getLimit() + "], Remaining[" +event.getRateLimitStatus().getRemaining()+"]");
    }
} );