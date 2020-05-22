RegistryMatcher matchers = new RegistryMatcher();
matchers.bind( org.joda.time.DateTime.class , JodaTimeDateTimeTransform.class );
// You could add other data-type handlers, such as the "YearMonth" class in Joda-Time.
//matchers.bind( org.joda.time.YearMonth.class , JodaTimeYearMonthTransform.class );

Strategy strategy = new AnnotationStrategy();
Serializer serializer = new Persister( strategy , matchers );