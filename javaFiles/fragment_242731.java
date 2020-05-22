public boolean add(Client c) {
    StringBuilder sb = new StringBuilder();
    boolean added = false;

    try {
        // call the function
        findID(c.getID());

    } catch (NoClientFound ex) {

      //handle the NoClientFound exception as you like here

       BufferedWriter bw = new BufferedWriter(
             new FileWriter(fitxer, true));
       //Add client to file
       bw.write(sb.append(c.getID()).append(SEPARADOR).
       append(c.getName()).toString());
       bw.newLine();//New line
       bw.flush(); //Push to file
       added = true;

    }catch (IOException ex) {
        Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null,
                "Error appeding data to file" + ex);
    }finally {

    }
    return addded;
}