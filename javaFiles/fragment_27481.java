boolean hasDuplicate = false;
Set<String> lines = new HashSet<String>();
while ( (line = list.readLine()) != null && !hasDuplicate )
    {
        if (lines.contains(line)) {
            hasDuplicate = true;
        }
        lines.add(line);
    }

    if (hasDuplicate){
        System.out.print("NOT UNIQUE");
    } else {
        System.out.print("UNIQUE");
    }
    list.close();
}