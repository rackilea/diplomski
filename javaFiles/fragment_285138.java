public class CardLayout implements LayoutManager2,
                                   Serializable {

    /*
     * This creates a Vector to store associated
     * pairs of components and their names.
     * @see java.util.Vector
     */
    Vector vector = new Vector();

    /*
     * Index of Component currently displayed by CardLayout.
     */
    int currentCard = 0;

    ...

    /* 
     * Hypothetical implementations
     */

    public boolean isDisplayingFirstCard() {
        return currentCard == 0;
    }

    public boolean isDisplayingLastCard() {
        return currentCard == vector.size() - 1;
    }
}