final String text = "abc: def,xyz: pqr, uvw: abchash<class qwerty,struct Hash<class qwerty>,struct std::equal_to<class qwerty> >::resize";

int start = 0;
Stack<Character> generics = new Stack<>();
for (int i = 0; i < text.length(); i++) {
    char c = text.charAt(i);
    switch (c) {
        case '<':
            generics.push(c);
            break;
        case '>':
            if(generics.isEmpty() || generics.pop() != '<') {
                throw new IllegalArgumentException("Invalid generic type constraints");
            }
            break;
        case ',':
            if (generics.isEmpty()) {
                System.out.println(text.substring(start, i));
                start = i + 1; //move window
            }
            break;
    }
}
if (generics.isEmpty()) {
    System.out.println(text.substring(start));
}