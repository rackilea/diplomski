public void foo() throws CustomException {

    try (InputStream is= new ...) {
        bar(is); //This throws a CustomException
    }
    catch (IOException e) { //The close() exception


    }
}