public Polynomial add(Polynomial p) {
    Polynomial answer = new Polynomial(this);
    for (ListIterator<Term> itr = answer.termList.listIterator(); itr.hasNext();) {
        Term term = itr.next();

        for (ListIterator<Term> itr2 = p.termList.listIterator(); itr2.hasNext();) {
            Term term2 = itr2.next();
            if (term.exponent == term2.exponent) {
                term.coefficient += term2.coefficient;
            } else {
                answer.termList.add(new Term(term2.exponent, term2.coefficient));
            }
        }
    }
    return answer;
}