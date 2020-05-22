Set<ScopeItem> scopeItems = items.stream()
    .map(scopeString ->
        {
           try
           {
              return ScopeItem.valueOf(scopeString);
           }
           catch (IllegalArgumentException e)
           {
              return null;
           }
        })
    .filter(Objects::nonNull)
    .collect(Collectors.toSet());