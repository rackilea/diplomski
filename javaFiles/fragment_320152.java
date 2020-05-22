while((line = br.readLine())!=null){
    String[] values = line.split(",");

    Iterator<ArrayList<String>> iter = map.values().iterator ();
    for (String value : values) {

        if (iter.hasNext()) {
            iter.next().add(value);
        }

    }
}