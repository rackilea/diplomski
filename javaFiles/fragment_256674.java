StringBuffer stringBuffer = new StringBuffer();
    Iterator<Integer> keySetIterator = jobdef.keySet().iterator();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        if (line.contains("DEFINE JOB ID")){
            jobdef.put(i, stringBuffer);
            i++;
            stringBuffer.setLength(0);
        }
        stringBuffer.append(line);
        //System.out.println("Line is" +line);
        stringBuffer.append("\n");
    }