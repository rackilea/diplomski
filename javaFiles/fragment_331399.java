interface Page {
    //general Methods ... save, openMedia, ...
}

class PageMedia {

    Page reference;

    public PageMedia(Page reference){
        this.refreence = reference;
    }

    public PageMedia upload(){return this;}
    public Page insert(){ return reference;}
}

class PageA implements Page{    
    public PageA dosomething(){ return this;}
    public PageMedia openMedia(){ return new PageMedia(this);}
    public Page save(){ return this;}

}