while (m < p.length){
    if (!check(B, p[m])) {
         B = parenthesis(p, m);
         printParenthesis(B);
    }
    m++;
}