class Throttler {
  final RateLimiter rateLimiter = RateLimiter.create(80.0/60.0);

  makeCall() {
    rateLimiter.acquire();
    doMakeCall();
  }
}