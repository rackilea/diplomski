private boolean decipherSignature(final SparseArray<String> encSignatures) throws IOException {
    // Assume the functions don't change that much
    if (decipherFunctionName == null || decipherFunctions == null) {
        String decipherFunctUrl = "https://s.ytimg.com/yts/jsbin/" + decipherJsFileName;

        BufferedReader reader = null;
        String javascriptFile;
        URL url = new URL(decipherFunctUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);
        try {
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder("");
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
            javascriptFile = sb.toString();
        } finally {
            if (reader != null)
                reader.close();
            urlConnection.disconnect();
        }

        if (LOGGING)
            Log.d(LOG_TAG, "Decipher FunctURL: " + decipherFunctUrl);
        Matcher mat = patSignatureDecFunction.matcher(javascriptFile);
        if (mat.find()) {
            decipherFunctionName = mat.group(1);
            if (LOGGING)
                Log.d(LOG_TAG, "Decipher Functname: " + decipherFunctionName);

            Pattern patMainVariable = Pattern.compile("(var |\\s|,|;)" + decipherFunctionName.replace("$", "\\$") +
                    "(=function\\((.{1,3})\\)\\{)");

            String mainDecipherFunct;

            mat = patMainVariable.matcher(javascriptFile);
            if (mat.find()) {
                mainDecipherFunct = "var " + decipherFunctionName + mat.group(2);
            } else {
                Pattern patMainFunction = Pattern.compile("function " + decipherFunctionName.replace("$", "\\$") +
                        "(\\((.{1,3})\\)\\{)");
                mat = patMainFunction.matcher(javascriptFile);
                if (!mat.find())
                    return false;
                mainDecipherFunct = "function " + decipherFunctionName + mat.group(2);
            }

            int startIndex = mat.end();

            for (int braces = 1, i = startIndex; i < javascriptFile.length(); i++) {
                if (braces == 0 && startIndex + 5 < i) {
                    mainDecipherFunct += javascriptFile.substring(startIndex, i) + ";";
                    break;
                }
                if (javascriptFile.charAt(i) == '{')
                    braces++;
                else if (javascriptFile.charAt(i) == '}')
                    braces--;
            }
            decipherFunctions = mainDecipherFunct;
            // Search the main function for extra functions and variables
            // needed for deciphering
            // Search for variables
            mat = patVariableFunction.matcher(mainDecipherFunct);
            while (mat.find()) {
                String variableDef = "var " + mat.group(2) + "={";
                if (decipherFunctions.contains(variableDef)) {
                    continue;
                }
                startIndex = javascriptFile.indexOf(variableDef) + variableDef.length();
                for (int braces = 1, i = startIndex; i < javascriptFile.length(); i++) {
                    if (braces == 0) {
                        decipherFunctions += variableDef + javascriptFile.substring(startIndex, i) + ";";
                        break;
                    }
                    if (javascriptFile.charAt(i) == '{')
                        braces++;
                    else if (javascriptFile.charAt(i) == '}')
                        braces--;
                }
            }
            // Search for functions
            mat = patFunction.matcher(mainDecipherFunct);
            while (mat.find()) {
                String functionDef = "function " + mat.group(2) + "(";
                if (decipherFunctions.contains(functionDef)) {
                    continue;
                }
                startIndex = javascriptFile.indexOf(functionDef) + functionDef.length();
                for (int braces = 0, i = startIndex; i < javascriptFile.length(); i++) {
                    if (braces == 0 && startIndex + 5 < i) {
                        decipherFunctions += functionDef + javascriptFile.substring(startIndex, i) + ";";
                        break;
                    }
                    if (javascriptFile.charAt(i) == '{')
                        braces++;
                    else if (javascriptFile.charAt(i) == '}')
                        braces--;
                }
            }

            if (LOGGING)
                Log.d(LOG_TAG, "Decipher Function: " + decipherFunctions);
            decipherViaWebView(encSignatures);
            if (CACHING) {
                writeDeciperFunctToChache();
            }
        } else {
            return false;
        }
    } else {
        decipherViaWebView(encSignatures);
    }
    return true;
}