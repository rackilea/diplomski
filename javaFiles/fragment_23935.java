Firebase ref = new Firebase("<my-firebase-app>/names"):
HashMap<String, String> names = new HashMap()<String, String>;
names.put("John", "John");
names.put("Tim", "Tim");
names.put("Sam", "Sam");
names.put("Ben", "Ben");
ref.setValue(names);