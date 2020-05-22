String data;
for (Integer key: hashMapClients.keySet()) {
    // initialize the value
    data = key + " | ";

    // build the value
    for (int i = 0; i <hashMapClients.get(key).size();i++) {
        data += hashMapClients.get(key).get(i).getType() + " | " + hashMapClients.get(key).get(i).getAmountOfClients() + ", ";
    }

    // write the value
    writer.println(data);
}