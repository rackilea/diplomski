for(Field member: myObject.getClass().getFields())
        // Or you can do: for(Field member: myClass.class.getFields())
    {
        member.getInt(myObject)); // Get the value
        member.setInt(myObject, 4); // Set the value
    }