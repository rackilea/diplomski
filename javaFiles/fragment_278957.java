while (child != null && element.compareTo(child.value) != 0)
{
    // do stuff here
}
// moved from inside the loop
if(child == null)
{
    System.out.println("Element not found.");
    return;
}