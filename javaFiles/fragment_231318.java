Object jsonObject = fromJson(listloggerdata);
  List<?> jsonDepartments = (List<?>) jsonObject;

  sort(jsonDepartments,sortBy("Date"));

  System.out.println("printing sorted" +jsonDepartments.toString());