else // go right
        {
            current = current.rightChild;
            if (current == null) // if end of the line
            {
                parent.leftChild = newNode;
                return;
            }
        }