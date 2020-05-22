Func<SomeObject, string, bool> predicate = (someObject, someId) =>
{
  if (someId.StartsWith("someText"))
  {
      // some logic
      return booleanResult;
  }
  return anotherBooleanResult;
};