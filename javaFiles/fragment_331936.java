private final PQueue<Integer> instance = new PQueue<Integer>();


@Test
public void testDequeue() throws Exception
{
  System.out.println( "Dequeue" );

  instance.Enqueue( 2, 1 );
  assertEquals( new ListNode<Integer>(2, 1), instance.Dequeue() );
}


@Test
public void testDequeue_DequeuedTwice() throws Exception
{
  System.out.println( "Dequeue_DequeuedTwice" );

  instance.Enqueue( 2, 1 );
  instance.Enqueue( 3, 2 );
  assertEquals( new ListNode<Integer>(2, 1), instance.Dequeue() );
}


@Test( expected=MyException.class) 
public void testDequeue_Empty() throws Exception
{
  System.out.println( "Dequeue_Empty" );

  instance.Dequeue();
}


@Test( expected=MyException.class) 
public void testDequeue_DequeuedTwice() throws Exception
{
  System.out.println( "Dequeue_DequeuedTwice" );

  instance.Enqueue( 2, 1 );
  instance.Dequeue();
  instance.Dequeue();
}