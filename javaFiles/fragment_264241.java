class PointerList
{
public:
// Default constructor : 
PointerList();

// Returns the next item in the list using currentPos
// If the end of the list is reached, 
// currentPos is reset to begin again.
ItemType getNextItem();

//other methods

private:
    int length;             // Number of nodes on list
    NodeType* listData;     // List head ptr
    NodeType* currentPos;   // List iterator
};