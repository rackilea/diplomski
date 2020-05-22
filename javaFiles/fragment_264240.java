class ArrayClass
{
public:
// Default constructor 
ArrayClass();

// Returns the next item in the list using currentPos
// If the end of the list is reached, 
// currentPos is reset to begin again.
ItemType getNextItem();

//other methods

private:
    int length;                // Number of items
    ItemType info[MAX_ITEMS];  // Array of items
    int currentPos;            // List iterator
};