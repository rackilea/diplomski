ListIterator listIter = list.listIterator();
while (listIter.hasNext()) { 
    HashObject value = listIter.next();       
    if(url.equals(value.getUrl())){
        value.setFrequency();
    }

    if(!url.equals(value.getUrl())){          
        listIter.add(new HashObject(title, term, url, 1, 1));
    }
}