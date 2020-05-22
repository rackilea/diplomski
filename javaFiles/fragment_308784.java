final List<MyClass> myList = DatabaseAccessUtil.getName();
    final List<String> lodgeNames = new ArrayList<String>();
    for (int i = 0; i < myList.size(); i++)
    {
        lodgeNames.add(myList.get(i).getGuestName());
    }

    lodges.add(
    new IValidator<String>() 
    { 
        private static final long serialVersionUID = 1L; 
        public void validate(IValidatable<String> validatable) 
        { 
            if (!lodgeNames.contains(validatable.getValue())) 
            { 
                validatable.error(new ValidationError(validatable.getValue() + " is not in the list. Please select establisment name from the list.")); 
            } 
        } 
    });