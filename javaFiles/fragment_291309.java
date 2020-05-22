call countX("Hello")
"Hello".length() != 0 so we move on to the next condition
"Hello".charAt(0) != 'x' so we call countX("Hello")
    call countX("Hello")
    "Hello".length() != 0 so we move on to the next condition
    "Hello".charAt(0) != 'x' so we call countX("Hello")
        call countX("Hello")
        "Hello".length() != 0 so we move on to the next condition
        "Hello".charAt(0) != 'x' so we call countX("Hello");
            .
            .
            .
            infinite recursion