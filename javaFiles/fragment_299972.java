if (parse >=1 && parse <= 7 )
    {

        switch (parse) {

            case 1:
                aShop.display();
                break;

            case 2:
                aShop.searchItem();
                break;

            case 3:
                aShop.addItem();
                break;

            case 4:
                aShop.addItemtoCart();
                break;


            case 5:
                aShop.displayCart();
                break;

            case 6:
                aShop.issueItem();
                break;

            case 7:
                System.out.println("Thank you!\n");
                flag = false;
                break;
        }
    }
    else {
        System.out.println("Please enter choice relevant to context");
        continue;
    }