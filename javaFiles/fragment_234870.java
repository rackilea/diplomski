Observable.range(0, 12)
    .filter { i-> Conn.connection(applicationContext) }
    .flatMap { i -> Api.create().getDateInMonth("2019-$i-01") } 
    .subscribeOn(io())
    .observeOn(mainThread())
    .subscribe({ i-> }, { t-> }, {/*onComplete*/ })