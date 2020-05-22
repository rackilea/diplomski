ArrayList<Child> children = new ArrayList<>();
for(int i=0; i<3; i++)
{
    Child child = new Child();
    child.setName("Bihar");
    children.add(child);

    ArrayList<Child> innerchildren = new ArrayList<>();
    for(int j=0; j<6; j++)
    {
        Child innerchild = new Child();
        innerchild.setName("Patna");
        innerchildren.add(innerchild);

        ArrayList<Child> innermostchildren = new ArrayList<>();
        for(int k=0; k<2; k++)
        {
            SizableChild innermostchild = new SizableChild();   // SizableChild extends Child and adds the methods setSize and getSize
            innermostchild.setName("CSE");
            innermostchild.setSize(4);

            innermostchildren.add(innermostchild);
        }
        innerchild.setChildren(innermostchildren);
    }
    child.setChildren(innerchildren);
}
myPojo.setChildren(children);