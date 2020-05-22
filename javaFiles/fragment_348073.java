Set<String> inputSet= new HashSet<String>();

for (int i = 0; i < 10; i++) {
    try {
        System.out.println("Device Address: ");
        String DevAdd = bufRead.readLine();

        // Check if already exists. If yes, throw exception
        if(inputSet.contains(DevAdd)) {
            throw new Exception("Already exists");
        }
        //  Indicates input does not exist in the set. Add it       
        inputSet.add(DevAdd);

        System.out.println("Device address:" + DevAdd);
    } catch (IOException err) {
        System.out.println("Error reading line");
    } catch (NumberFormatException err) {
        System.out.println("Error Converting Number");
    }
}