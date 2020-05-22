static final String CHAMORRO_RULES = ("< a,A < å,Å < b,B < ch,Ch < d,D < e,E < f,F < g,G < h,H < i,I < k,K < l,L "
      + "< m,M < n,N < ñ,Ñ < ng,Ng < o,O < p,P < r,R < s,S < t,T < u,U < y,Y");
  static final RuleBasedCollator CHAMORRO_COLLATOR;
  static {
    try {
      CHAMORRO_COLLATOR = new RuleBasedCollator(CHAMORRO_RULES);
    }
    catch (ParseException pe) {
      throw new RuntimeException(pe);
    }
  }