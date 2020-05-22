public class test {
        public static void main(String[] args) throws Exception {

            URL oracle = new URL("http://www.oracle.com/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                if(inputLine.contains("</head>")) break;
                System.out.println(inputLine);
            }
            in.close();
        }

    }