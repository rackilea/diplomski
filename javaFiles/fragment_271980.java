{
    Resource r = allocation;
    Throwable primary = null;
    try {
        …
    }
    catch(Throwable t) { primary = t; }
    finally {
        if(r != null) try {
            r.close();
        }
        catch(Throwable t) {
            if(primary!=null) primary.addSuppressed(t); else primary=t;
        }
    }
    if(primary!=null) throw primary;
}