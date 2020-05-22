try {
  subscriptionAdminClient.createSubscription(subscription, 
                                             topic,
                                             PushConfig.getDefaultInstance(),
                                             0);
} catch (ApiException e) {
  if (e.getStatusCode() != Status.Code.ALREADY_EXISTS) {
    throw e;
  }
}

// You know the subscription exists and can create a Subscriber.