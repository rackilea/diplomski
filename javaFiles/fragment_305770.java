for (Food f : foodList) {
            if (f.isSelected) {
                totalPrice += Integer.parseInt(f.getPrice());
            }

            //totalPrice variable now has the total of all selected items
        }