Object result = ois.readObject();
if ("[ERROR]".equals(result)) {
   // something was wrong server side
   throw SomeException();
} else {
   usersList = (ArrayList<HashMap<String, String>>) result;
}