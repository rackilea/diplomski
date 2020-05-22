for (String key:result.keySet()) {
        //if Node, then add it to array
        if (key.charAt(0) == 'N') { //'N' and not "N"
            nodeList[i] = String.valueOf(result.get(key));
            counter++;
        }
    }