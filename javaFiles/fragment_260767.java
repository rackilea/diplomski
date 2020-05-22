class Function {
    public void add(Function f) {
        f.addMe(this);
    }

    public void addMe(Function f) {
        // Default case
        throw NotImplementedException();
    }
    public void addMe(Logarithmic log) {
        // Code that handles the real
    }
}

class Logarithmic extends Function {
    // This object supports adding
    public void add(Function f) {
        f.addMe(this);
    }
}


Logarithmic log = new Logarithmic();
log.add(new Function()); 
log.add(new Logarithmic()); 

Function f = log;
f.add(new Function()); 
f.add(new Logarithmic());