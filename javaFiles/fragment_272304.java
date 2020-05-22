TreeSet<Element> nt = new TreeSet<Element>(new Comparator<Element>(){
        public int compare(Element a, Element b){
            if ( a == b ) 
                return 0;
            if ( (a.val - b.val) > 0 )
                return 1;
            return -1;
        }
    });

for (Element elem: elements ){
    nt.add(elem);
}