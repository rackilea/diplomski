KStream stream = builder.stream(...)

// each record in `stream` will be "duplicated" and sent to all `filters`
stream.filter(...).grouByKey().count(); // or aggregate() instead of count()
stream.filter(...).grouByKey().count();
// ...