KStream stream = builder.stream(...)
KStream[] subStreams = stream.branch(...);

// each record of `stream` will be contained in exactly _one_ `substream`
subStream[0].grouByKey().count(); // or aggregate() instead of count()
subStream[1].grouByKey().count();
// ...