subject
    .filter(i -> i instanceof MenuItem)
    .subscribe(menuItemSubscriber);
subject
    .filter(i -> i instanceof ParametrizedItem)
    .subscribe(paramertizedItemSubscriber);