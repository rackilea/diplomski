int size = Integer.parseInt(st.nextToken());
       System.out.println(size);

       // We read the next line into "nextline", this is okay but not pretty.
       // Also you need to check that nextline is not `null` here.
       nextline = reader.readLine();

       StringTokenizer st2 = new StringTokenizer(nextline, ","); //why???