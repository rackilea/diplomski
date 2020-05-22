BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter details of shipments with *ONLY ONE* space in between multiple lines. Please separate items in one shipping container with :");
        String line = buf.readLine();

        //First separate out the space.
        String[] columnStrings = line.split(" ");

        for (String columnString : columnStrings) {
            String[] columns = columnString.split(":");
            String id = columns[0];
            String street = columns[1];
            String city = columns[2];
            String state = columns[3];
            String zipcode = columns[4];
            String country = columns[5];
            // close the input stream
            buf.close();
            //append first child element to root element
            rootElement.appendChild(getShipmentDetails(doc, id, street, city, 
state, zipcode, country));
        }