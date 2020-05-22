bindListener(Matchers.any(), new TypeListener()
{
  @Override
  public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> iTypeEncounter)
  {
    if (typeLiteral.getRawType().isAnnotationPresent(AfterInjectionListener.class))
    {
      logger.debug("adding injection listener {}", typeLiteral);
      iTypeEncounter.register(new InjectionListener<I>()
      {
        @Override
        public void afterInjection(I i)
        {
          try
          {
            logger.debug("after injection {}", i);
            i.getClass().getMethod("afterInjection").invoke(i);
          } catch (NoSuchMethodException e)
          {
            logger.trace("no such method", e);
          } catch (Exception e)
          {
            logger.debug("error after guice injection", e);
          }
        }
      });
    }
  }
});