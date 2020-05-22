if(entries.hasNext()) 
        fW.write(entry.next());

while (entries.hasNext()) {
        fW.write("\n");
    fW.write(entry.next());
}