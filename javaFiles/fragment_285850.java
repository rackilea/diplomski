PolicyMap policyMap = broker.getDestinationPolicy();
PolicyEntry policy = new PolicyEntry();
policy.setSubscriptionRecoveryPolicy( new LastImageSubscriptionRecoveryPolicy() );
ActiveMQDestination destination = (ActiveMQDestination) session.createTopic(
   "a.topic" );

policyMap.put( destination, policy );