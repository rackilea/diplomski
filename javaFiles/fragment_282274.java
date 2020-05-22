Node n = root;
for (char c: number) {
    if ((child = n.hasChild(c)) != null)
    {
       prefix += c;
       n = child;
    }
    else
       break;
}