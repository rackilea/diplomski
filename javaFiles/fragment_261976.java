if(lookahead.equals("CHARACTERS")){
    match("CHARACTERS");
    while (SetDecl()) ;
    return true;
}
/* ... */