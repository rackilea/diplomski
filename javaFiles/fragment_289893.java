public static void main(String[] args) throws FileNotFoundException {
        List<String> nameArr = new ArrayList<>();
        List<Double> intArr = new ArrayList<>();
        System.out.print("Enter the State name: ");
        Scanner in = new Scanner(System.in);
        String inputFileName = in.next();

        Scanner sc = new Scanner(new File("pplnames17.txt"));

        while (sc.hasNextLine()) {
            String nameLine = sc.nextLine();
            if (nameLine.contains(inputFileName)) {
                String[] inputs = nameLine.split(" ");
                for (String input : inputs) {
                    if (isNumeric(input)) {
                        intArr.add(Double.parseDouble(input));
                    } else {
                        nameArr.add(input);
                    }
                }
            }
        }
        if (!nameArr.isEmpty()) {
            System.out.println(nameArr);
        } else {
            System.out.println("No names found");
        }
        if (!intArr.isEmpty()) {
            System.out.println(intArr);
        } else {
            System.out.println("No numbers found");
        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }