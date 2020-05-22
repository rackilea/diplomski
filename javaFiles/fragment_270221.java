while ((line = mbr.readLine()) != null) 
{
    enSecretText=encrypt(line);
    bwr.write(enSecretText.toString());
    bwr.newLine();
}