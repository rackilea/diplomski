InputStream fs;
        fs = new URL("http://example.com/file.txt").openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ArrayList<String> array = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null)
            array.add(br.readLine());
        Random rand = new Random();
        int randomIndex = rand.nextInt(array.size());
        Uri uri = Uri.parse(array.get(randomIndex));