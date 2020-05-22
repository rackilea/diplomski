...
error = new ErrorController(node.getScene().getWindow());
...

try {
    int key = Integer.parseInt(keyTextField.getText());
    System.out.println(key);
} catch (NumberFormatException e) {
    error.show();    
}