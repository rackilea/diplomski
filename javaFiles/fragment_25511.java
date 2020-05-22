if(next!=null)
    {
        if(root.data>n && root.data<next.data)
        return root;
        else
        return next;

    }
    else 
    {
        if(root.data>n)
        return root;
        else 
        return null;
    }