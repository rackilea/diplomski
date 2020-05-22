new ExistingUser(
    new DemandAwareUser(
        new SafelyBorrowingUser(
            new SimpleUser(cardId)
        )
    )
).borrowItem(item);