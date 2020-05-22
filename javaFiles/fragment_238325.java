public static void main(String[] args) {
    String regex = "\\d+.?\\d* (mg |teaspoon |mcg |tablet |units |puffs |tab )(\\d )(P.O. )*((once )daily|B.I.D.|(once )a day|Q.I.D.|nightly|P.R.N.|T.I.D.|every (other )(day|morning))";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher("1.5 mg 10 mg 1 P.O. nightly");
    while(m.find()){
        System.out.println(m.group());
    }

}