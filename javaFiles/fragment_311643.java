while ((s = br.readLine()) != null) {

    if (s.indexOf("id=" +infoToRemove) == -1) {
       wr.println(s);
    }
}