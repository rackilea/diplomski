class GenericStack {
   @Test public void test() {
      final IStack<Integer> stack = new EmptyStack<Integer>();
      assertEquals(new Integer(1), stack.push(1).getTop());
      assertEquals(new Integer(2), stack.push(1).push(2).getTop());
      assertEquals(new Integer(1), stack.push(1).push(2).pop().getTop());
   }

   interface IStack<T> { 
      INonEmptyStack<T, ? extends IStack<T>> push(T x);
   }

   interface IEmptyStack<T> extends IStack<T>
   {
       @Override INonEmptyStack<T, IEmptyStack<T>> push(T x);
   }

   interface INonEmptyStack<T, TStackBeneath extends IStack<T>> 
      extends IStack<T>
   {
       T getTop();
       TStackBeneath pop();
       @Override INonEmptyStack<T, INonEmptyStack<T, TStackBeneath>> 
          push(T x);
   }

   class EmptyStack<T> implements IEmptyStack<T> {
      @Override public INonEmptyStack<T, IEmptyStack<T>> push(T x) {
         return new NonEmptyStack<T, IEmptyStack<T>>(x, this);
      }
   }

   class NonEmptyStack<T, TStackBeneath extends IStack<T>> extends Object 
      implements INonEmptyStack<T, TStackBeneath> {
      private final TStackBeneath stackBeneathTop;
      private final T top;

      NonEmptyStack(T top, TStackBeneath stackBeneathTop) {
         this.top = top;
         this.stackBeneathTop = stackBeneathTop;
      }

      @Override public T getTop() {
         return top;
      }

      @Override public TStackBeneath pop() {
         return stackBeneathTop;
      }

      @Override public INonEmptyStack<T, INonEmptyStack<T, TStackBeneath>> 
         push(T x) {
         return 
            new NonEmptyStack<T, INonEmptyStack<T, TStackBeneath>>(x, this);
      }
   }

   // The following client code at the request of @TacticalCoder demonstrates
   // some of the benefits (and limitations) of this implementation.

   @Test public void testRandomPopper() {
      IStack<?> stack = randomPopper(new EmptyStack<Integer>(), 20);
      // This assertion will fail 1 out of .3^20 runs 
      assertTrue(stack instanceof INonEmptyStack<?,?>); 
      assertFalse(stack instanceof IEmptyStack<?>); 
   }

   public IStack<Integer> randomPopper(IStack<Integer> s, final int N) {
      IStack<Integer> stack;
      if(N<1)
         return s;
      stack = s.Push(1);
      for (int i = 1; i < N; i++) {
         INonEmptyStack<Integer,?> tStack = stack.Push(i+1);
         if(Math.random()<0.3) {
            stack = tStack.Pop();            
         } else {
            stack = tStack;
         }
      }
      return stack;
   }

   @Test public void testDrainStack() {
      IStack<Integer> stack = randomPopper(new EmptyStack<Integer>(), 20);
      IStack<?> maybeEmptyStack = drainStack(stack);
      assertTrue(maybeEmptyStack instanceof IEmptyStack);
      IEmptyStack<?> definitelyEmptyStack = (IEmptyStack<?>) maybeEmptyStack;
      assertTrue(definitelyEmptyStack instanceof IEmptyStack<?>); 
   }

   @Test public void testCastNonEmptyStackToEmptyStack() {
      IStack<Integer> stack = randomPopper(new EmptyStack<Integer>(), 20);
      IStack<?> maybeEmptyStack = stack;
      assertFalse(maybeEmptyStack instanceof IEmptyStack);
      // Below cast should issue warning!  Doesn't and issues runtime error.
      IEmptyStack<?> definitelyEmptyStack = (IEmptyStack<?>) maybeEmptyStack;
      assertFalse(definitelyEmptyStack instanceof IEmptyStack<?>); 
   }

   public IStack<?> drainStack(IStack<?> stack) {
      for (;stack instanceof INonEmptyStack<?,?>;)
         stack = ((INonEmptyStack<?,?>) stack).Pop();
      return stack;
   }
}