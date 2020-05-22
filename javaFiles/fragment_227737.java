boolean isPresent = Optional.ofNullable(newContainer)
  .map(Container::getComponentArray)
  .map(arr -> {
    for (Component component : arr) {
      if (Objects.equals(component.getName(), ipName)) {
        return true;
      }
    }
    return false;
  })
  .orElse(false);