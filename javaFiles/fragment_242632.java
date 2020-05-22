for (int i = 0; i < s.length(); ++i) {
    char c = s.charAt(i);
    if (c == '(')
        CounterFancy.incCounter();
    else if (c == ')')
        CounterFancy.decCounter();
}