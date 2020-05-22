String[] phone_numbers= new String[] { "1234", "5678" }; // populate from DB instead
PhoneNumbers numbers = new PhoneNumbers(phone_numbers);

// to serialize
Serializer serializer = new Persister();
serializer.write(numbers, System.out);