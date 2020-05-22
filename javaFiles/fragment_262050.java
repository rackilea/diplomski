while (line!=null) {
        strbuild.append(line);
        strbuild.append("\n");
        if(line.equalsIgnoreCase("fender")){
            count++;
        }
        line = buffer.readLine();
    }