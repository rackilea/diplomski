String[] level = {
            " aaaaaaaaa",
            " aaaaaaaaa",
            " aaaaaaaaa",
            " aaaaaaaaa",
            " aaaaaaaaa",
            "aaaaaaaaaa",
            "aaaaaaaaaa",
            "saaaggaaaa",
            "ggggccgggg",
            "cccccccccc",
            "aaaaaaaaaa",
            "aaaaaaaaaa",
            "cccccccccc"
};
for(int c = 0; c < level.length; c ++){
    for(int r = 0; r < level[c].length(); r ++){
        switch(level[c].charAt(r)) {
            case 'a':
                // do something    
                break;
            case 'g':
                // etc   
        }
    }
}