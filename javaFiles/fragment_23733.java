String ndata = reader.readLine();
while (ndata != null) {
    osw.write(ndata+"\n");
    osw.flush();
    LOG.log(Level.INFO,"Sent");

    ndata reader.readLine();
}