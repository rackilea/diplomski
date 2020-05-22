struct node* findMergeNode(struct node* list1, struct node* list2)
{
    // Assuming list1 is of size m
    // Assuming list2 is of size n

    int len1, len2, diff;
    struct node* head1 = list1;
    struct node* head2 = list2;

    len1 = getlength(head1); // O(m) - as you need to iterate though it
    len2 = getlength(head2); // O(n) - same here
    diff = len1 - len2;

    // Right now you already reached O(m+n)

    if (len1 < len2) // O(1)
    {
        // this entire block is of constant length, as there are no loops or anything
        head1 = list2;
        head2 = list1;
        diff = len2 - len1;
    }

    // So we are still at O(m+n)

    for(int i = 0; i < diff; i++) // O(abs(m-n)) = O(diff)
        head1 = head1->next;

    // As diff = abs(m-n) which is smaller than m and n, we can 'ignore' this as well
    // So we are - again - still at O(m+n)

    while(head1 !=  NULL && head2 != NULL) // O(n-diff) or O(m-diff) - depending on the previous if-statement
    {
        // all the operations in here are of constant time as well
        // however, as we loop thorugh them, the time is as stated above
        if(head1 == head2)
            return head1->data;
        head1= head1->next;
        head2= head2->next;
    }

    // But here again: n-diff < n+m and m-diff < n+m
    // So we sill keep O(m+n)

    return NULL;
}