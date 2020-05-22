ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    try {
        ArrayList<String> RSSname = new ArrayList<String>();
        ArrayList<String> username= new ArrayList<String>();
        ...
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    System.out.println("Done");

    return data;