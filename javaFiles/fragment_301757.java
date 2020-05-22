String testString = "Hello {USERNAME}! Welcome to the {WEBSITE_NAME}!";
Map<String, String> replacementStrings = Map.of(
                "USERNAME", "My name",
                "WEBSITE_NAME", "My website name"
        );
StrSubstitutor sub = new StrSubstitutor(replacementStrings , "{", "}");
String result = sub.replace(testString );