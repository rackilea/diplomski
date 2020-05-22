// You assign the reference to the `String` maintained by the text field...
String text = field.getText(); 
System.out.println(text); // prints "0+" like expected (after pressing number)

/* Checks for operation chars */
for(int i = 0; i < ops.length; i++) {
    if(text.endsWith(ops[i])) {
        // You assign a NEW reference to the text field, this
        // won't change the contents of text as they are different
        // references...
        field.setText("");
        System.out.println("called"); //gets printed
        break;
    }
}

// text has not changed, this variable and the field contents are not
// magically linked
System.out.println(text); //even when "called" prints, text is not ""