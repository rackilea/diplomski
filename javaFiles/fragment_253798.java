Optional<Map.Entry<Integer, Product>> result = 
      items.entrySet()
           .stream()
           .reduce((Map.Entry<Integer, Product> a, Map.Entry<Integer, Product> b) ->
                        a.getValue().getPrice() < b.getValue().getPrice() ? b : a);

return result.isPresent() ? result.get().getValue() : null;