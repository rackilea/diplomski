apiResultStream
  .map(next -> {
        if (next) doSomeCallWithNextWhenTrue(next);
        else doSomeCallwithNextWhenFalse(next);
      })
  .subscribe(...