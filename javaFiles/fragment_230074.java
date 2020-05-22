while (( line = bf.readLine()) != null){
            linecount++;

            int indexfound = line.indexOf(stringSearch);

            while(indexfound > -1)
            {
                System.out.println(stringSearch + " was found at position " + indexfound + " on line " + linecount);
                System.out.println(line);
                indexfound = line.indexOf(stringSearch, indexfound);
            }
        }