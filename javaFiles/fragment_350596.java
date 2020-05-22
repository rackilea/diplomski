for (int i = 0; i < sentence.length(); i++){
    if ( sentence.charAt(i) == sentence.charAt(i+1)) pairs++;
}

String s = "AABBCC";

first loop, i = 0 : compare s[0] to s[1]
first loop, i = 1 : compare s[1] to s[2]
first loop, i = 2 : compare s[2] to s[3]
first loop, i = 3 : compare s[3] to s[4]
first loop, i = 4 : compare s[4] to s[5]
first loop, i = 5 : compare s[5] to s[6] // WOAH, you can't do that! there is no s[6]!!