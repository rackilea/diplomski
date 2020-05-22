@Override
public String getHeader () {
    try (BufferedReader br = new BufferedReader (new FileReader (fileName)) {

        String line = br.readLine ();
        if (line != null)
            return null;

    } catch (IOException e) {
        e.printStackTrace ();
    }

    return FIRST_LINE + SECOND_LINE + THIRD_LINE + FOURTH_LINE;
}