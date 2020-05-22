String input = editText.getText().toString().split(" ");

    Map<String, String> pairs = new HashMap<>();
    pairs.put("is", "was");
    pairs.put("shall", "should");
    pairs.put("this", "that");
    pairs.put("can", "could");
    pairs.put("will", "would");

    String output = "";

    for (String word : input) {
        if (pairs.containsKey(word)) {
            output = output + pairs.get(word) + " ";
        } else {
            output = output + word + " ";
        }
    }

    mTextView.setText(output.trim());