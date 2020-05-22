public class ParentBean {}

public class Bean1Included extends ParentBean {}

public class Bean2Included extends ParentBean {}

public class Bean3Included extends ParentBean {}

@Qualifier("excludedBean")
public class BeanExcluded extends ParentBean {}