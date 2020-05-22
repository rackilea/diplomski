public LinkedList<Term> deepCopy(LinkedList<Term> p)   {
    //implement this!
}
public QRPair dividePolynomials(LinkedList<Term> a, LinkedList<Term> b) {
    LinkedList<Term> q = "0"    //set q to be the polynomial 0
    LinkedList<Term> r = deepCopy(a);  //want a copy of a, not just reference.      
    while(!isEmpty(r) && (r.highestDegree() > d.highestDegree()))
    {
            int co = r.get(0).getCo()/d.get(0).getCo();
            int ex = r.get(0).getEx()/d.get(0).getEx();
            Term t = new Term(co,ex);
            q = addPolynomials(q,t);
            r = subtractPolynomials(r,multiplyPolynomials(t,d));
            //assume subtract/multiplyPolynomial returns LinkedList<Term>
    }
    return QRPair(q,r);
}