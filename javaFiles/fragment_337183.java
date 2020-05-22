public int compare(FileItem o1, FileItem o2) {

        int result = 0;
        if (o1 != null && o2 != null) {

            String n1 = o1.getFileName();
            String n2 = o2.getFileName();

            if (n1 != null && n2 != null)
                result = n1.compareTo(n2);
        }

        return result;
    }