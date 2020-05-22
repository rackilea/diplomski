// "report" is a final string that is exected 
// after value.ToString(); execution
String report = String.Combine(",", queryOptions
  .Select(pair => String.Format("{0}:{1}", 
     pair.Key, 
     isArray(pair.Value) ? pair.Value : "'" + pair.Value + "'"))
  );