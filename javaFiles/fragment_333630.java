if (c == secret.charAt(0))
    return replaceChar(partial, secret, c);
if (c == secret.charAt(1))
    return replaceChar(partial, secret, c);
// :
// and so on.