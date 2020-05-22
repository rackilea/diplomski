while ((line = bufferedReader.readLine()) != null) {
            if("".equals(line)){
                continue;
            }
            char h = line.charAt(7);
            System.out.println(h);
        }