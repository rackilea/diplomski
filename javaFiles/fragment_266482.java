public Author(String f, String l, boolean authorCheck){
    firstName = f;
    lastName = l;
    if(authorCheck)
    {
        author = this;
    }
}

public Author(String f, String l){
    firstName = f;
    lastName = l;
    author = this;
}