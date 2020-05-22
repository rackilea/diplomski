List<Card> cardsToDeal = this.cards.subList(0, numCardsToDeal);
IntStream.range(0, cardsToDeal.size()).forEach(idx -> {
    DealOneCardToPlayer(
        this.table.players.get(idx % this.table.GetPlayerCount()),
        cardsToDeal.get(idx));
});
cardsToDeal.clear();