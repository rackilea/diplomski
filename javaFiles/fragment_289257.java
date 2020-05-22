public Light getLight(String name) {
    String line;
    double x, y, z, r, g, b, x1, y1, z1;

    try {
        while((line = bufferedReader.readLine()) != null) {
            if(line.startsWith(name)) {
                Scanner parser = new Scanner(line);
                x = parser.nextDouble();
                y = parser.nextDouble();
                // continue assigning variables

                // break out of while loop, only interested in one line
                break;
            }
        }

        return new Light(new Vector3f(x , y, z), new Vector3f(r, g, b), new Vector3f(x1, y1, z1));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}