public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scan = new Scanner(new File("file.txt"))) {
            String rows[] = scan.useDelimiter("\\Z").next().split("\n");
            for (String s : rows) {
                System.out.println(s);
            }
            String start="'";
            String end="'";

            System.out.println("------------------------------------------------------------------");

            List<StringBuilder> groups = new ArrayList<StringBuilder>();
            StringBuilder result = new StringBuilder();
            //Add starting groups

            for (String line : rows) {
                if (line.trim().endsWith("{")) {
                    //group start
                    result.append(start);
                    //It is already in the new group
                    result.append(line);
                } else if (line.trim().endsWith("}")){
                    //is still with the last group
                    result.append(line);
                    //group end
                    result.append(end);
                }else{
                    result.append(line);
                }
            }
                System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }