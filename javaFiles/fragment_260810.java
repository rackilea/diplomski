// make a transformer that combines all of them as one
Transformer combinedTransformer =

    // the stream of transformers
    transformers.stream()

    // combine all the transformers into one
    .reduce(

        // the no-op transformer
        x -> x,

        // apply each of the transformers in turn
        (t1, t2) -> x -> t2.apply(t1.apply(x)))

    );



// the stream of strings
strings.stream()

// transform each string with the combined transformer
.map(combinedTranformer::apply);