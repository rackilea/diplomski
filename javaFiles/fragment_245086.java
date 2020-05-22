CompositeSubscription mSubscription = new CompositeSubscription();
SerialSubscription mPullRequest = new SerialSubscription();

{
    mSubscription.add(mPullRequest); // Stop all requests if mSubscription is unsubscribed
}

private void pullToRefresh() {
    /* same code as before */
    mPullRequest.set(subscription);
}