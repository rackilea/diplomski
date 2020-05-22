int index = tweet.title.indexOf("I"); // find int position of "I"

// set to be the String of where "I" is to plus 1 of that position
CharSequence i = tweet.title.substring(index, index + 1);

// Alternative to substring, you could use charAt, which returns a char
CharSequence i = Character.toString(tweet.title.charAt(index));