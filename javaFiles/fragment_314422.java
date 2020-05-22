private String transformString(String input) {
        Stack<Pair<Integer, String>> childParams = new Stack<>();
        String parsedInput = input;
        int nextInt = Integer.MAX_VALUE;
        Pattern pattern = Pattern.compile("\\((\\w|\\|| )+\\)");
        Matcher matcher = pattern.matcher(parsedInput);
        while (matcher.find()) {
            nextInt--;
            parsedInput = matcher.replaceFirst(String.valueOf(nextInt));
            String childParam = matcher.group();
            childParams.add(Pair.of(nextInt, childParam));
            matcher = pattern.matcher(parsedInput);
        }

        parsedInput = transformBasic(parsedInput);
        while (!childParams.empty()) {
            Pair<Integer, String> childGroup = childParams.pop();
            parsedInput = parsedInput.replace(childGroup.fst.toString(), transformBasic(childGroup.snd));
        }
        return parsedInput;
    }

    // Transform basic only handles strings that contain words. This allows us to simplify the problem
    // and not have to worry about child groups or nested groups.
    private String transformBasic(String input) {
        String transformedBasic = input;
        if (input.startsWith("(")) {
            transformedBasic = input.substring(1, input.length() - 1);
        }

        // Append + in front of each word if there are multiple words.
        if (transformedBasic.contains(" ")) {
            transformedBasic = transformedBasic.replaceAll("( )|^", "$1+");
        }
        // Surround all words containing | with parenthesis.
        transformedBasic = transformedBasic.replaceAll("([\\w]+\\|[\\w|]*[\\w]+)", "($1)");
        // Replace pipes with spaces.
        transformedBasic = transformedBasic.replace("|", " ");
        if (input.startsWith("(") && !transformedBasic.startsWith("(")) {
            transformedBasic = "(" + transformedBasic + ")";
        }
        return transformedBasic;
    }