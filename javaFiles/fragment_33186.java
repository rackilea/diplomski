String s = "Whatever you want it to be.".toLowercase();
int vowelCount = 0;
for (int i = 0, i < s.length(); ++i) {
    switch(s.charAt(i)) {
        case 'a':
            vowelCount++;
            break;
        case 'e':
            vowelCount++;
            break;
        case 'i':
            vowelCount++;
            break;
        case 'o':
            vowelCount++;
            break;
        case 'u':
            vowelCount++;
            break;
        default:
            // do nothing
    }
}