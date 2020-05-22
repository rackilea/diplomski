// get composite transform for 'e'
t.setToIdentity();
t.translate(e.getX(), e.getY());
t.rotate(...);

tmp = e.getParent();
while (tmp != null) {

    // get composite transform for parent
    t3.setToIdentity();
    t3.translate(tmp.getX(), tmp.getY());
    t3.rotate(...);
    tmp = tmp.getParent();

    t.preConcatenate(t3); // t3 is applied after t
}

e.draw(g2d, t);