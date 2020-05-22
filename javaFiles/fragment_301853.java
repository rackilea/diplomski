else if (event.getActionCommand().equals("Remove")) {
            boolean removed = false;
            titleText.setText("Integer Sums");
            for (int i = 0; i < counter; i++) {
                if (Integer.parseInt(inputField.getText()) == numbers[i]) {
                    for (int x = i; x < counter; x++) {
                        if (x == 9) {
                            numbers[x] = 0;
                        } else {
                            numbers[x] = numbers[x + 1];
                            numbers[x + 1] =0;
                        }
                    }
                    textArea.setText(Arrays.toString(numbers));
                    counter--;
                    removed = true;
                }               
            }
            if (!removed) {
                titleText.setText("Error: value doesn't exist");
            } 
            System.out.println("Counter: " + counter);
        }