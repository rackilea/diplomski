public class Company {

    /**
     * Array of available company names used to construct
     * initial companies. These names are also used as possible
     * choices when changing company names through {@link #changeCompanyNames()}
     */
    private static final String[] COMPANY_NAMES = new String[]
            { "Alphabet", "Microsoft", "IBM", "Amazon", "Oracle", "Apple" };

    /**
     * <p>
     * Array of Company objects initialized with a fixed number of
     * new companies equal to the number of String entries in {@link #COMPANY_NAMES}.
     * </p><p>
     * Each company entry will inheriting a name from the mentioned array
     * in the initialization process done in {@link #initializeCompanies()}
     * </p>
     */
    public static final Company[] COMPANIES = initializeCompanies();

    private String name;

    /**
     * Internal constructor with private access to
     * prevent class construction outside this class
     */
    private Company(String name) {
        this.name = name;
    }

    /**
     * Should only be used internally on class loading to
     * construct an array of companies from a list of company names.
     */
    private static Company[] initializeCompanies() {

        Company[] companies = new Company[COMPANY_NAMES.length];
        for (int i = 0; i < COMPANY_NAMES.length; i++) {
            companies[i] = new Company(COMPANY_NAMES[i]);
        }
        return companies;
    }

    /**
     * Change any or all company names by prompting the user to choose
     * a new name for each company from the list of available companies.
     */
    public static void changeCompanyNames() {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        /*
         * Create a new array of company names that is identical to the existing
         * array of company names. We will change names here on user input and
         * then update each new company name to values from this array.
         */
        final String[] finalCompanyNames = COMPANY_NAMES.clone();
        /*
         * Iterate through an array of companies with a for-loop
         * accessing and processing each company entry
         */
        for (int i1 = 0; i1 < COMPANIES.length; i1++)
        {
            /* Prompt the user to choose a new company name for the
             * company at index i1 from COMPANIES array.
             */
            System.out.printf("Choose a new company name for %s company:%n", COMPANIES[i1].name);
            /*
             * Again iterate through all companies and print their names to
             * console offering the user a list of possible names to choose from
             */
            for (int i2 = 0; i2 < COMPANIES.length; i2++) {
                System.out.printf("%d. %s%n", i2 + 1, COMPANIES[i2].name);
            }
            /*
             * Get user input and validate it, then either update the array of
             * final names with the new entry or print an error and move the index
             * to the previous position if the input was an invalid number
             */
            int input = scanner.nextInt();
            if (input > 0 && input <= COMPANIES.length) {
                finalCompanyNames[i1] = COMPANY_NAMES[input - 1];
                System.out.println("You have choosen company name " + finalCompanyNames[i1]);
            }
            else {
                System.out.printf("Error: input is not in range (1-%d)%n", COMPANIES.length);
                /*
                 * It's imperative that we move the index to the previous
                 * position so we can iterate over this company entry again
                 */
                i1 -= 1;
            }
        }
        // Print simple line separator
        System.out.println("");

        /* Print each choosen name that is different then the original
         * company name and update the appropriate company name field value
         */
        for (int i = 0; i < finalCompanyNames.length; i++)
        {
            if (!finalCompanyNames[i].equals(COMPANY_NAMES[i])) {
                System.out.printf("Company %s has changed name to %s%n", COMPANY_NAMES[i], finalCompanyNames[i]);
                COMPANIES[i].name = finalCompanyNames[i];
            }
        }
    }
}