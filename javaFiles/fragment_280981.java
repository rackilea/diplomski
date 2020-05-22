@Override
    public void setNextNode(Node nextNode) throws NullPointerException, IllegalArgumentException{
        if (nextNode == null){
            throw new NullPointerException(NULL_NODE_ERROR);
        }
        if ( ! (nextNode instanceof SingleLinkedNode) ) {
            throw new IllegalArgumentException ("Node is not SingleLinkedNode");
        }

        this.nextNode = (SingleLinkedNode) nextNode;
    }