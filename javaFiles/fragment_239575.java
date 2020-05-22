public String getValid( String context, String input ) throws ValidationException
    {
        String data = null;

        // checks on input itself

        // check for empty/null
        if(checkEmpty(context, input) == null)
            return null;

        if (validateInputAndCanonical)
        {
            //first validate pre-canonicalized data

            // check length
            checkLength(context, input);

            // check whitelist patterns
            checkWhitelist(context, input);

            // check blacklist patterns
            checkBlacklist(context, input);

            // canonicalize
            data = encoder.canonicalize( input );

        } else {

            //skip canonicalization
            data = input;           
        }

        // check for empty/null
        if(checkEmpty(context, data, input) == null)
            return null;

        // check length
        checkLength(context, data, input);

        // check whitelist patterns
        checkWhitelist(context, data, input);

        // check blacklist patterns
        checkBlacklist(context, data, input);

        // validation passed
        return data;