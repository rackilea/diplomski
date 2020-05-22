public void pixelOn(int zeile, int spalte) {
    if (pixelAt(zeile, spalte) == null) {
        Pixel neu = new Pixel(zeile, null);
        Pixel it = data[spalte];
        if(it!=null){
            if(it.getZeile()<zeile){
                Pixel tmp=it.getNext();
                while(tmp!=null && tmp.getZeile()<zeile){
                    it = tmp;
                    tmp = it.getNext();
                }
                it.setNext(neu);
                neu.setNext(tmp);
            }else{
                neu.setNext(it);
                data[spalte] = neu;
            }
        }else{
            //there is nothing in the column for now add it
            data[spalte] = neu;
        }
    }
}