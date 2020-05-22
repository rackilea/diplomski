class SchedulingEventQueue extends EventQueue
    {
      // Use Map< AWTEvent, List< AWTEvent > > to support multiple events
      private final Map< AWTEvent, AWTEvent > eventSchedule = new HashMap< AWTEvent, AWTEvent >();

      public void scheduleEvent( final AWTEvent event, final AWTEvent dependentEvent )
      {
        eventSchedule.put( dependentEvent, event );
      }

      @Override
      protected void dispatchEvent( final AWTEvent event )
      {
        try
        {
          super.dispatchEvent( event );
        }
        finally
        {
          // Dispatch any dependent event
          AWTEvent scheduledEvent = eventSchedule.remove( event );
          if( scheduledEvent != null )
          {
            postEvent( scheduledEvent );
          }
        }
      }
    }

    // Now the code to post the events becomes:
    {
      SchedulingEventQueue eventQueue = new SchedulingEventQueue();

      Toolkit.getDefaultToolkit().getSystemEventQueue().push( eventQueue );

      MouseEvent pressEvent = new MouseEvent(target, MouseEvent.MOUSE_PRESSED, ...)
      MouseEvent releaseEvent = new MouseEvent(target, MouseEvent.MOUSE_RELEASED, ...)
      MouseEvent clickEvent = new MouseEvent(target, MouseEvent.MOUSE_CLICKED, ...)

      eventQueue.scheduleEvent( clickEvent, releaseEvent );
      eventQueue.scheduleEvent( releaseEvent, pressEvent );
      eventQueue.postEvent( pressEvent );
    }