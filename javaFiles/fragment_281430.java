List<Token> filtered =
    listResult.stream()
              .filter(t -> t.getStatus().equals(TokenStatus.ACTIVE.code()))
              .limit(2)
              .collect(Collectors.toList());
if (filtered.size () != 1) {
    throw new new IllegalStateException(Messages.ONE_TOKEN_MUST_BE_ACTIVATED);
}
Token token = filtered.get(0);