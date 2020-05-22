// This function is called every frame on the main thread
public void update()
{
    final Components components = Storage.sComponents;
    // If we have our components, print them out
    if (components != null)
    {
        print(components.mVar1);
        print(components.mVar2);
    }
}