else {

             int firstItem; // this the first item, it will either be discarded (not included) or placed in the sack array (included)
             firstItem = items[0];

             items = Arrays.copyOfRange(items, 1, items.length); // for either recursive branch: remove the first item from the list

             recknapSack(capacity, items, 1); // call recursive function, left branch, where item is discarded and not placed in sack

             // prepare for right branch, where item is placed in sack
             capacity -= firstItem; // subtract the left most item weight from from capacity
             int temp = pos;
             sack[pos++] = firstItem; // place the item in the sack
             System.out.println("First item " + firstItem);
             int ret = recknapSack(capacity, items, 2); // recursive right branch call, item is placed in sack, weight subtracted from capacity
             if(ret != 0)
             {
                  System.out.println("Removing " + sack[temp] + " at position " + (temp));
                 sack[temp] = 0;
                 pos = temp;
             }


      }