StringWriter sw = new StringWriter() {
        @Override
        public void close() throws IOException {
            super.close();
            System.out.println("closed");
        }
};
try (PrintWriter pw = new PrintWriter(sw)) {};