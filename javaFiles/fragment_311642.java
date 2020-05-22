while ((s = br.readLine()) != null) {

    if (s.indexOf(infoToRemove) == -1) {
       wr.println(s);
    }
}