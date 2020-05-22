// sourceCode is a string containing all the source file's text
var sourceCode = "...";

// startIndex is the index of the char AFTER the opening brace
// for the method we are interested in
var methodStartIndex = 42;

var openBraces = 1;
var insideLiteralString = false;
var insideVerbatimString = false;
var insideBlockComment = false;
var lastChar = ' '; // White space is ignored by the C# parser,
                    // so a space is a good "neutral" character

for (var i = methodStartIndex; openBraces > 0; ++i) {
    var ch = sourceCode[i];

    switch (ch) {
        case '{':
            if (!insideBlockComment && !insideLiteralString && !insideVerbatimString) {
                ++openBraces;
            }
            break;
        case '}':
            if (!insideBlockComment && !insideLiteralString && !insideVerbatimString) {
                --openBraces;
            }
            break;
        case '"':
            if (insideBlockComment) {
                continue;
            }
            if (insideLiteralString) {
                // "Step out" of the string if this is the closing quote
                insideLiteralString = lastChar != '\';
            }
            else if (insideVerbatimString) {
                // If this quote is part of a two-quote pair, do NOT step out
                // (it means the string contains a literal quote)

                // This can throw, but only for source files with syntax errors
                // I 'm ignoring this possibility here...
                var nextCh = sourceCode[i + 1]; 

                if (nextCh == '"') {
                    ++i; // skip that next quote
                }
                else {
                    insideVerbatimString = false;
                }
            }
            else {
                if (lastChar == '@') {
                    insideVerbatimString = true;
                }
                else {
                    insideLiteralString = true;
                }
            }
            break;
        case '/':
            if (insideLiteralString || insideVerbatimString) {
                continue;
            }

            // TODO: parse this
            // It can start a line comment, if followed by /
            // It can start a block comment, if followed by *
            // It can end a block comment, if preceded by *

            // Line comments are intended to be handled by just incrementing i
            // until you see a CR and/or LF, hence no insideLineComment flag.
            break;
    }

    lastChar = ch;
}

// From the values of methodStartIndex and i we can now do sourceCode.Substring and get the method source