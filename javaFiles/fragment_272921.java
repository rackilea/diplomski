// ...
} catch (Exception e) {
    e.printStackTrace(); // instead of System.out.println("error");
    setErrorMessage(response, 400, "Bad Request", "Could not select data. Check the data given as input.");
    return;
}