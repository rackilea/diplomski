List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
// add some PhoneNumbers to the list
List<String> extensions =
  new ListPropertyGetter<String, PhoneNumber>()
  {
    @Override
    public String get(PhoneNumber source)
    {
      return source.getExtension();
    }
  }.getListOfProperties(phoneNumbers);