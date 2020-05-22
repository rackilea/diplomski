public Generalization findSubClass(String s){        
     for(Generalization gen : subClasses){
        if(s.equals(gen.getName())) return gen;
        else {
            Generalization subGen = gen.findSubClass(s);
            if (subGen != null)
                return subGen;
        }
     }
     return null;
}