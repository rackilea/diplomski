@Override
    protected void process(List<String> chunks) {
        // Grab the last element...
        textfield.setText(chunks.get(chunks.size() - 1));
    }
}