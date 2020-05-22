private static final Set<Character> 
        vowels = new HashSet<>
        (Arrays.asList('a','e','i','o','u','y'));

private static final Set<Character> 
        cons = new HashSet<>
        (Arrays.asList('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'));

...

    for (int i = 0; i < input.length(); i++) {
        Character result = input.charAt(i);
        if (vowels.contains(result))
            vnum++;
        else if (cons.contains(result))
            cnum++;
        else
            snum++;
    }