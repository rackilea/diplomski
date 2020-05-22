try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true)))
{
    while(true){
        List<String> data = toWrite.poll(10, TimeUnit.SECONDS);
        if (data == null) {
           break;
        }
        save(data, writer);
    }
} catch (...) {
}