/**
 * Gets the distinct values of the specified field name.
 *
 * @param fieldName   the field name
 * @param resultClass the class to cast any distinct items into.
 * @param <TResult>   the target type of the iterable.
 * @return an iterable of distinct values
 * @mongodb.driver.manual reference/command/distinct/ Distinct
 */
<TResult> DistinctIterable<TResult> distinct(String fieldName, Class<TResult> resultClass);