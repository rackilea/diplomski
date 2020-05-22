Arrays.sort(listDir, new Comparator<File>() {
        @Override
        public int compare(File o1, File o2) {
            int num1 = Integer.parseInt(o1.getName().split("\\.")[0]);
            int num2 = Integer.parseInt(o2.getName().split("\\.")[0]);
            return num1 - num2;
        }
    });