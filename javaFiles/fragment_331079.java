while ((line = br.readLine()) != null) {
    Employee e = new Employee();
    StringTokenizer st = new StringTokenizer(line);
    int counter = 0;
    while (st.hasMoreTokens()) {
        String token = st.nextToken();
        if (counter==0){
            // Set the name
        }
        if (counter == 1) {
            // Set the manager
        }

        // employees.add(e); // Move this line from here
        counter++;
    }//end while2
    employees.add(e); // to here : the name & the manager are now both set
}//end while1