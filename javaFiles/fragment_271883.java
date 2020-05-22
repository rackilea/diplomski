Process child = ...;
kill (child.toHandle());

public void kill (ProcessHandle handle)
{
    handle.descendants().forEach((child) -> kill(child));
    handle.destroy();
}