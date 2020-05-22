final InputStream inputStream = specialisationResource.getInputStream();
final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

String line;
while ((line = bufferedReader.readLine()) != null) {
    data.add(getNewTransientSpecialisation(line));
}