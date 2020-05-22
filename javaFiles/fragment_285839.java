class ChenYingTestCase extends ServiceTestCase
{
       /**
        * Gets the current system context and stores it.
        * You can not extend this method.
        * If you want to achieve the effect of extending this method,
        * you must override chenYingSetupMethod.
        **/
       public final void setUp ( )
       {
             super.setUp ( ) ;
             chenYingSetup ( ) ;
       }

       /**
        * Does nothing (unless you extend it)
        *
        * Extend this method to do your 
        * own test initialization. If you do so, there is no need to call super.setUp() 
        * Hint:  calling super.setUp() is probably a bad idea.
        * as the first statement in your override.
        * Just put your test initialization here.
        * The real SetUp method will call super.setUp() and then this method.
        **/
       protected void chenYingSetUp ( )
       {
       }
}