public class FieldExclusionStrategy  implements ExclusionStrategy {
    private Set<String> ignored = 
            new HashSet<String>(Arrays.asList( new String[]{"horsePower","weight"}));
    @Override
    public boolean shouldSkipField(FieldAttributes arg0) {
        if(arg0.getDeclaringClass().isAssignableFrom(Engine.class))
            if(ignored.contains(arg0.getName())) return true;
        return false;
    }       
    @Override
    public boolean shouldSkipClass(Class<?> arg0) { return false; }
}