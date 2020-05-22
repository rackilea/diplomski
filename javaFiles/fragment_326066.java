String s = "[1,2,[],[a,b],[ab,bc,cd],[1,2,[3,4],[5,6],7]]";
StringBuilder sb = new StringBuilder();
int nest = 0;
for (int i = 1; i < s.length() - 1; ++i) {
    char ch = s.charAt(i);
    switch (ch) {
    case ',':
        if (nest == 0) {
            System.out.println(sb);
            sb.setLength(0);
            continue;
        }
        break;
    case '[': ++nest; break;
    case ']': --nest; break;
    }
    sb.append(ch);
}
System.out.println(sb);