void set(String data[]) throws DataFormatException {
    try {
        a = Integer.parseInt(data[0]);// convert the string into int.
                                        // eg1.("12"
                                        // ---> 12) eg2.("df23" ---> fail)
        b = Integer.parseInt(data[1]);
        c = 0;
    } catch (NumberFormatException e) {
        throw new DataFormatException(e);
    } catch (ArrayIndexOutOfBoundsException e) {
        throw new DataFormatException(e);
    }
}