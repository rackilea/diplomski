// Create a stream, that emits each item from the list, in this case "param1" continued with "param2" and then "param3"
    Observable.fromIterable(listOf("param1", "param2", "param3"))
      // we are converting `Observable` stream into `Completable`
      // also we perform request here: first time parameter `it` is equal to "param1", so a request is being made with "param1"
      // execution will halt here until responce is received. If response is successful, only then a call with second param ("param2") will be executed
      // then the same again with "param3"
      .flatMapCompletable { api.getUser(it) }
      // we want request to happen on a background thread
      .subscribeOn(Schedulers.io())
      // we want to be notified about completition on UI thread
      .observeOn(AndroidSchedulers.mainThread())
      // here we'll get notified, that operation has either successfully performed OR failed for some reason (specified by `Throwable it`)
      .subscribe({ println("completed") }, { println(it.message) })