findMinIndex(data, 1);
// is there an element after 1? There is. So we end up calling findMinIndex again...

findMinIndex(data, 2); // is there an element after 2? Yes. Recurse...

findMinIndex(data, 3); // is there an element after 3? No. That's the end of the array

// remember this part? it's used now to finally terminate the recursion
if (index == data.length - 1)
    return index; // this equals 3