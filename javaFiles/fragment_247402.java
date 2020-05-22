@Service
class Service {


private int attemptsLeft=12;

@Retryable(maxAttempts=12, backoff=@Backoff(delay=100, maxDelay=500))
public service() {
    // ... do something that throws a KnownException you create to catch later on.
}

@Recover
public void connectionException(KnownException e) {
            this.attemptsLeft = this.attemptsLeft-1; //decrease your failure counter
            Logger.warn("Retry attempts left:{}",attemptsLeft);
        }
}