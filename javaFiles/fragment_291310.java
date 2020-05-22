call countX("Hello")
"Hello".length() != 0 so we move on to the next condition
"Hello".charAt(0) != 'x' so we call countX("ello")
    call countX("ello")
    "ello".length() != 0 so we move on to the next condition
    "ello".charAt(0) != 'x' so we call countX("llo")
        call countX("llo")
        "llo".length() != 0 so we move on to the next condition
        "llo".charAt(0) != 'x' so we call countX("lo");
            call countX("lo")
            "lo".length() != 0 so we move on to the next condition
            "lo".charAt(0) != 'x' so we call countX("o");
                call countX("o")
                "o".length() != 0 so we move on to the next condition
                "o".charAt(0) != 'x' so we call countX("");
                    call countX("")
                    "".length() == 0 so return 0
                return 0
            return 0
        return 0
    return 0
return 0