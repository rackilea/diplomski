String everything = "";

    AssetManager am = context.getAssets();
    InputStream is = am.open(filename);
    BufferedReader br = new BufferedReader(is);
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append('\n');
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
        inputStream.close();
    }

    TextView tw = (TextView) findViewById(R.id.hello);
    tw.setText(everything);