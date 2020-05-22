// identity = ""
BiFunction<String,String,String> accumulator = String::concat;

// identity = null
BiFunction<StringBuilder,String,StringBuilder> accumulator =
    (builder,name) -> builder == null
        ? new StringBulder(name) : builder.append(name);