Observable.create({ Subscriber<Bin> subscriber ->
    new Thread({ ->
        List<List<String>> lists = binData.getData()
        ... // shorten for brevity
    } as Runnable).start()
} as Observable.OnSubscribe<Bin>)