try {
  subscriptionAdminClient.getSubscripton(subscription);
} catch (ApiException e) {
  if (e.getStatusCode() == Status.Code.NOT_FOUND) {
    // Create the subscription
  } else {
    throw e;
  }
}

// You know the subscription exists and can create a Subscriber.