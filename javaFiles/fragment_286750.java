.collect(Collectors.toMap(
       o -> o.getKey(),
       o -> {
          final User value = o.getValue();
          return SimpleUser.of(user.getId(), user.getName(), user.getCountry());
       }
));