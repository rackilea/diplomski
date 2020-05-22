for (int i = 0; i < parselength; i++) {

            arraynode = jsonarray.getJSONObject(i);
            ID[i] = arraynode.getString("Id");
            City[i] = arraynode.getString("City");
            Etag[i] = arraynode.getString("ETag");
            Address[i] = arraynode.getString("Address");

            JSONArray jsonarraylink = new JSONArray(arraynode.getJSONArray("Links").toString());

            int linklength = jsonarraylink.length();
            Links[i] = new String[linklength];
            for (int j = 0; j < linklength; j++) {
                linknode = jsonarraylink.getJSONObject(i);
                Links[i][j] = linknode.getString("Href");
                System.out.println(linknode.getString("Href"));
            }
            //JSONArray innerLink = new JSONArray(arraynode.getString("Links"));

            strCSV += Etag[i] + "," + ID[i] + "," + City[i] + "," + Address[i] + "\r\n";    //   
        }