while( st.hasMoreTokens() ){
    String TOKEN = st.nextToken();
    if ( isOpeningBracket(TOKEN) ){
        System.out.print(TOKEN + "\t");
        System.out.println("Is Left  Bracket");
        continue;
    }
    else if ( isClosingBracket(TOKEN) ){
        System.out.print(TOKEN + "\t");
        System.out.println("Is Right  Bracket");
        continue;
    }
    isOperator(TOKEN);
    isReservedWord(TOKEN);
    isIdentifier(TOKEN);
}