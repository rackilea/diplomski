btn.setOnAction(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent event) {
            totalPrice += price;
            pizzaCounter++;
            do {
               totaal[count] = name;
               count++;
               data.add(name + " " + price);
            } while (bonActive());

            pizzaCounterText.setText("Items bought: " + Integer.toString(pizzaCounter) + "\nTotal: " + Double.toString(totalPrice * korting));
                System.out.println(Arrays.deepToString(totaal));

            }
        });