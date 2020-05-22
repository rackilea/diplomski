tab.sort { a, b ->
    [ a, b ]*.tokenize( '.' ).with { u, v ->
        [ u, v ].transpose().findResult { x, y ->
             x.toInteger() <=> y.toInteger() ?: null
        } ?: u.size() <=> v.size()
    }
}