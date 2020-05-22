StringBuilder sb = new StringBuilder(); 
    int i;
    while ((i = is.read()) != -1) {
        char c = (char) i;
        if (c != '$')
            sb.append(c);
    }

    InputStream nis =  new ByteArrayInputStream(sb.toString().getBytes());