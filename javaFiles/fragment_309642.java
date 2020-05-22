class Pattern {
    IPatternComponent[] pattern;
    boolean matches(String str) {
        for(int i = 0; i < str.length; i++) {
            if(!pattern[i].matches(str.charAt(i)))
                return false;
        }
        return true;
    }
}

interface IPatternComponent {
    boolean matches(char ch);
}

class Simple implements IPatternComponent {
    char ch;
    boolean matches(char ch) {
        return (this.ch == ch);
    }
}

class Group implements IPatternComponent {
    Set<IPatternComponent> components;
    boolean matches(char charToMatch) {
        for(IPatternComponent comp : components) {
            if(comp.matches(charToMatch)
                return true;
        }
        return false;
    }
}