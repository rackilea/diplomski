public String toReadableString()
    {
        String result = "Displaying all contacts and information:";
        for (Contact contact : members) {
            result += "\n\t" + contact.toReadableString();
        }
        return result;
    }