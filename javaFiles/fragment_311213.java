@Override
public Object decorate(ClassLoader loader, Field field) {
    if (!(WebElement.class.isAssignableFrom(field.getType())
        || Select.class.isAssignableFrom(field.getType())
        || List.class.isAssignableFrom(field.getType())
        || isDecoratableList(field))) {
      return null;
    }

    ElementLocator locator = factory.createLocator(field);
    if (locator == null) {
      return null;
    }

    if (WebElement.class.isAssignableFrom(field.getType())) {
      return proxyForLocator(loader, locator);
    } else if (List.class.isAssignableFrom(field.getType())) {
          return proxyForListLocator(loader, locator);
    } else if (Select.class.isAssignableFrom(field.getType())) {
          return new Select(locator.findElement());
    } else {
      return null;
    }
}