while((s = br.readLine()) != null){
        out.println("<tr>");
        StringTokenizer s2 = new StringTokenizer(s, "|");
        while (s2.hasMoreTokens()){
            if (index == 0){
                String one = s2.nextToken();
                int i = one.indexOf(".");
                out.println("<td>"+one.substring(0 , i)+"."+"</td>");
            }