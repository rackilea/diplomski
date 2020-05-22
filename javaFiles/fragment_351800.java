} catch (NotAnInt | ParseError e) {
    // a step or two in common to both cases
    if (e instanceof NotAnInt) {
        // handle NotAnInt
    } else  {
        // handle ParseError
    }
    // potentially another step or two in common to both cases
}