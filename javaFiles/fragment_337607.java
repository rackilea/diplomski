public class A {

    public enum SearchOption {
        SEARCH_L,
        SEARCH_M,
        SEARCH_A,
        SEARCH_K;
    }
    /**
     * Make them pass in an enum for your search.
     * Pros: type safe, can only use the selections you give
     * Cons: must add to the enum to add new types
     * @param option
     */
    public void enumSearch(SearchOption option) {

        switch(option) {
        case SEARCH_A:
            System.out.println("I am searching for A");
            break;
        case SEARCH_K:
            System.out.println("I am searching for K");
            break;
        case SEARCH_L:
            System.out.println("I am searching for L");
            break;
        case SEARCH_M:
            System.out.println("I am searching for M");
            break;
        }
    }

    /**
     * Use a primitive for your input
     * Pros: Gives you more options without updating the enum
     * Cons: Users could enter input you don't really want them to use
     * @param option
     */
    public void charSearch(char option) {
        switch(option) {
        case 'a':
        case 'A':
            System.out.println("I am searching for A");
            break;
        case 'k':
        case 'K':
            System.out.println("I am searching for K");
            break;
        case 'l':
        case 'L':
            System.out.println("I am searching for L");
            break;
        case 'm':
        case 'M':
            System.out.println("I am searching for M");
            break;
        }
    }

    /**
     * Use a primitive and don't even actually check it! Just run with it!
     * @param option
     */
    public void uncheckedSearch(char option) {
        System.out.println("I am searching for " + option);
    }
}