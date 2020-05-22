public static String read(String filename) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(filename));

    String s;
    StringBuilder sb = new StringBuilder();
    while((s = in.readLine())!= null) {
        String[] split1 = s.split("=");

        if (split1[0].equals("name")) {

            StringTokenizer tokenizer = new StringTokenizer(split1[1]);
            sb.append(tokenizer.nextToken());
            sb.append(",");

            sb.append(tokenizer.nextToken());
            sb.append(",");


        } else if (split1[0].equals("index")) {

            sb.append(split1[1] + ",");

        } else if (split1[0].equals("FBid")) {
            sb.append(split1[1]);

        } else {

            StringTokenizer tokenizer = new StringTokenizer(split1[1]);
            String wasted = tokenizer.nextToken();

            sb.append(tokenizer.nextToken() + ",");

        }

    }

    in.close();

    return sb.toString();
}