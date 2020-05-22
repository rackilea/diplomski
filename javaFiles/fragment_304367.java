try{
 Document doc = Jsoup.connect(url).post();
    // it gets here, when it works
}   catch(InvalidUrlException e){
    //bla bla bla...
}