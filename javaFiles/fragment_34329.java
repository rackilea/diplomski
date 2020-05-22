static List<String> listSnapshotNames(VirtualMachineSnapshotTree[] snapTree) {
    ArrayList<String> result = new ArrayList<String>();
    collectSnapshots(snapTree, result);
    return result;
}

static void collectSnapshots(VirtualMachineSnapshotTree[] snapTree, List<String> names)
{
    VirtualMachineSnapshotTree node;
    VirtualMachineSnapshotTree[] childTree;

    for(int i=0; snapTree!=null && i < snapTree.length; i++)
    {
        node = snapTree[i];
        names.add(node.getName());
        childTree = node.getChildSnapshotList();

        if(childTree != null)
        {

            collectSnapshots(childTree, names);
        }
    }//end of for
}