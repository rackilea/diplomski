public class BreakKeyCompletionPolicy extends CompletionPolicySupport{
    private BreakKeyCompletionContext cc;
    private PeekableItemReader<Object> reader;
    // Strategy used to check for value break
    private BreakKeyStrategy<Object> strategy;

    public void setReader(PeekableItemReader<Object> forseeingReader){
        this.reader = forseeingReader;
    }

    @Override
    public boolean isComplete(RepeatContext context){
        return this.cc.isComplete();
    }

    @Override
    public RepeatContext start(RepeatContext context)   {
        context.setAttribute("current", null);
        this.cc = new BreakKeyCompletionContext(context);
        return cc;
    }
    /** Context contains current element ("current" property" and manage next element.
     * Null next element is treated as a key break
     */
    protected class BreakKeyCompletionContext extends RepeatContextSupport {
        public BreakKeyCompletionContext(RepeatContext context)     {
            super(context);
        }
        public boolean isComplete(){
            final Object next;
            try{
                next = reader.peek();
            }
            catch (Exception e){
                throw new NonTransientResourceException("Unable to peek", e);
            }
            if (null == next){
                return true;
            }
            return strategy.isKeyBreak(this.getAttribute("current"), next);
        }
    }

    @AfterRead
    public void afterRead(Object item){
        this.cc.setAttribute("current", item);
    }
}