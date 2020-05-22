boolean pathExists(Model m, IRI start, IRI end, IRI... properties) {
    for(IRI p: properties) {
        Model fromStart = m.filter(start, p, null);  
        if (fromStart.contains(start, p, end)) {
               return true;
        }
        else { 
            for (Value obj: fromStart.objects()) {
                if (obj instanceof Resource) {
                     if(pathExists(m, obj, end, properties)) {
                            return true;
                     }              
                }
            } 
        }
    }
    return false;
}