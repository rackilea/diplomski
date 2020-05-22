while ((receiveString = bufferedReader.readLine()) != null) {
    stringBuilder.append(receiveString);

    // The next line is the problem
    // bufferedReader.readline() is either null
    // or array is null

    // bufferedReader.readLine() is going to be set to null on the last run.
    array.set(enc, Double.parseDouble(bufferedReader.readLine()));

    ++enc;
}