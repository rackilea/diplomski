while((line = lector.readLine())!=null) {

    String[] arr = line.split("[^a-zA-Z0-9']");
    String res = "";

    for(String s : arr) {
        res += s;
    }

    matrix.add(res);    
}