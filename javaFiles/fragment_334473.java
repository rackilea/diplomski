Vector a = new Vector();
Vector b = new Vector();

// populate vectors a and b
// ...

Vector c = new Vector();

for(Enumeration e = a.elements(); e.hasMoreElements();) {
    c.addElement(e.nextElement());
}
for(Enumeration e = b.elements(); e.hasMoreElements();) {
    c.addElement(e.nextElement());
}

// c now contains all elements from a followed by all elements from b