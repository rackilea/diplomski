// doesn't match
[0-9]{1,}[A-Za-z]{1,}|
// matches "i5"
[A-Za-z][0-9]{1,}|
// the following are never even checked, because of the previous match
[a-zA-Z][a-zA-Z0-9\\.\\-_/#]{2,}|
[0-9]{3,}[A-Za-z][a-zA-Z0-9\\.\\-_/#]*|
[0-9][0-9\\-]{4,}|
[0-9][0-9\\-]{3,}[a-zA-Z0-9\\.\\-_/#]