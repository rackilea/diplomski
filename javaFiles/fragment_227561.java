// Old HTML: <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
String result2 =
    result.replaceFirst("([\"'])text/html.*\\1",
                        "$1text/html; charset=UTF-8$1");

if (result2 == result) { // Not replaced.
    // HTML 5: <meta charset="ISO-8859-1">
    result2 =
        result.replaceFirst("(?si)<meta\\s*charset=([\"']).*\\1>",
                            "<meta charset=\"UTF-8\">");
}

if (result2 == result) { // Not replaced.
    // No statement, add one, to read as file:
    result2 =
        result.replaceFirst("(?si)<head>",
            "$0<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
}

result = result2;