Observable.fromIterable(listOfElements)
          .filter(element -> {
              if (element.isValid()) {
                  // do some action with valid `element`
                  // NOTE: this action would be performed with each valid element
                  return true;
              } else {
                  // `element` is not valid, perform appropriate action
                  // NOTE: this action would be performed for each invalid element
                  return false;
              }
          })
          .toList() // collect all the filtered elements into a List
          .subscribe(
                  filteredElements -> /* use `filteredElements` which is List<Element> */, 
                  throwable -> /* perform appropriate action with this `throwable`*/)
          );