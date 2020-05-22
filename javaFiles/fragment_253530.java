public class Main
{
    public static void visit(final ThreadGroup group, final int level)
    {
        final Thread[] threads = new Thread[group.activeCount() * 2];
        final int numThreads = group.enumerate(threads, false);

        for (int i = 0; i < numThreads; i++)
        {
            Thread thread = threads[i];
            System.out.format("%s:%s\n", group.getName(), thread.getName());
        }

        final ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount() * 2];
        final int numGroups = group.enumerate(groups, false);

        for (int i = 0; i < numGroups; i++)
        {
            visit(groups[i], level + 1);
        }
    }

    public static void main(final String[] args)
    {
        ThreadGroup root = Thread.currentThread().getThreadGroup().getParent();
        while (root.getParent() != null)
        {
            root = root.getParent();
        }

        visit(root, 0);
    }
}