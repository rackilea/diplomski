while (needsSorting) // <-- Loop 1
{
    needsSorting = false; // Neah 

    // Go through the items in the array, and see if there are any suspicions
    for (...) // <-- Loop 2
    {
        // Do I still need to go over the loop again?
        if (successive elements are not in order)
        {
            // Switch elements here
            ...
            needsSorting = true; // Yep, make another pass over the array
        }
    }
}