public class LA5ex2 {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String str = null;
        String token = null;
        int totalMiles = 0;
        int lines = 0;
        ArrayList<String> flierClasses = new ArrayList<String>();
        ArrayList<Integer> mileages = new ArrayList<Integer>();

        try {
            while((str = input.readLine()) != null) {
                lines++; // Why are we counting the lines, anyway?
                StringTokenizer tokenizer = new StringTokenizer(str);
                while(tokenizer.hasMoreTokens()) {
                    token = tokenizer.nextToken();

                    if(!(IsInteger.IsaInteger(token))) {
                        flierClasses.add(token); // if it's not an int, we assume it's a flier class
                    } else {
                        mileages.add(Integer.parseInt(token)); // if it's an int, it's a mileage
                    }
                }
            }
        } catch(NumberFormatException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch(IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

        // Add everything up
        for(int i = 0; i < flierClasses.size(); i++) {
            totalMiles += calculateFlierMiles(flierClasses.get(i), mileages.get(i));
        }

        System.out.println("Frequent-flier miles the person earns: " + totalMiles);
    }

    private static int calculateFlierMiles(final String flierClass, final int mileage) {
        if(flierClass.equals("firstclass")) return(2 * mileage);
        else if(flierClass.equals("coach")) return(1 * mileage);
        else if(flierClass.equals("discount")) return(0 * mileage);
        return 0;
    }
}