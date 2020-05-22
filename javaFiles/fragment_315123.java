val udpObservable = Observable.create<Int> { emitter ->
        val listener = object : SocketListener() {
            override fun onUdpServerListenerCreated(inetAddress: InetAddress, port: Int) {
                emitter.onNext(port)
                emitter.onComplete()
            }

        }
        //add listener here
        socketSource.subscribe(listener)
        emitter.setCancellable { socketSource.unSubscribe(listener) }
    }.subscribeOn(Schedulers.io())

      //need add this for work with emmit data on background 
     .observerOn(Schedulers.newThread())
            .doOnNext { Log.d("123-thread", "current is: " + Thread.currentThread().name) }
            .onErrorReturn { throw ConnectionException(it) }
            .subscribe()