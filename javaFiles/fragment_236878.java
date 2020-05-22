function fb(a) {
    var b, c, d;
    d = (bb(), window);
    b = d.document;
    c = b.createElement('script');
    (!!a.a || a.b) && cb(c, a.a, a.b);
    eb(c, a.c);
    (b.head || b.getElementsByTagName('head')[0]).appendChild(c);
    return c
}