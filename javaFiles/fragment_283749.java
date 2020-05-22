@SuiteClasses({SuiteOne.class, SuiteTwo.class})
@RunWith(Suite.class)
public class TopLevelSuite {}

@SuiteClasses({Test1.class, Test2.class})
@RunWith(Suite.class)
public class SuiteOne {}


@SuiteClasses({Test4.class, Test3.class})
@RunWith(Suite.class)
public class SuiteTwo {}