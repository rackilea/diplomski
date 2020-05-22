public class Outer
{
    private static class NotVisibleToSubclassesOfOuter {}

    protected static class VisibleToSubclassesOfOuter {}
}