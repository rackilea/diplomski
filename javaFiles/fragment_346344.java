verify(commandGatewayMock, times(1))
            .send(
                            new CreateEventProposalCommand(
                                    any(EventProposalId.class),
                                    eventProposalName,
                                    EventDescription.of(eventDescription),
                                    minimalInterestThreshold
                            )
            );