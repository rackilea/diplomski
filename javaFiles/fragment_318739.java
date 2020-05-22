if (value == addButtonType) {
     return new Batch() {
        {
            setCode(code.getText());
            setName(name.getText());
        }
     };
}