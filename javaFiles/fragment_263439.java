ArrayList<Children> aChild = new ArrayList<>();
for(int i=0; i<3; i++)
{
    Children child = new Children();
    child.setName("Bihar");

    ArrayList<Children1> aChild1 = new ArrayList<>();
    for(int j=0; j<6; j++)
    {
        Children1 child1 = new Children1();
        child1.setName("Patna");

        ArrayList<Children2> aChild2 = new ArrayList<>();
        for(int k=0; k<2; k++)
        {
            Children2 child2 = new Children2();
            child2.setName("CSE");
            child2.setSize(4);

            aChild2.add(child2);
        }
        child1.setChildren2(aChild2);
        aChild1.add(child1);
    }
    child.setChildren1(aChild1);
    aChild.add(child);
}
myPojo.setChildren(aChild);