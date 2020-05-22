IntegrationFlows
            .from(messageChannel)
            .split(s -> s
                    .applySequence(false).get().getT2().setDelimiters("[\r\n]"))
            .aggregate(s -> s
                            .correlationExpression("payload")
                            .releaseExpression("size() >= 10")
                            .expireGroupsUponCompletion(true)
                            .expireGroupsUponTimeout( 500 )
            )
            .handle(h ->
                    System.out.println(h))

            .get();