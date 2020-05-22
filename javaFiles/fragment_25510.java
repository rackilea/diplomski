if(next!=null)
{
    if(root.data>n && root.data<next.data)
    return root;
    else
    return next;

}
else 
return null;