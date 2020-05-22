try{
    CharArrayWriter br = new CharArrayWriter();
    Throwable x = null;

    try{
        br.writeTo(null);
    } catch (Throwable t) {goto L51;}
    catch (Throwable t) {goto L59;}

    if (br != null) {
        if (x != null) {
            try{
                br.close();
            } catch (Throwable t) {
                x.addSuppressed(t);
            }
        } else {br.close();}
    }
    break;

    try{
        L51:
        x = t;
        throw t;

        L59:
        Throwable t2 = t;
    } catch (Throwable t) {goto L59;}

    if (br != null) {
        if (x != null) {
            try{
                br.close();
            } catch (Throwable t){
                x.addSuppressed(t);
            }
        } else {br.close();}
    }
    throw t2;
} catch (IOException e) {
    System.out.println(e)
}