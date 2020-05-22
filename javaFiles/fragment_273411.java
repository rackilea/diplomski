private String returnDetailMessage(Discount discountType, Object quantity, Object claims) {
            String detailMessage
            switch (discountType) {
                case Percentage:
                    if (quantity > claims) {
                        detailMessage = "There are not enough discounted strings for you to do this"
                        break
                    } else {
                        detailMessage = "this is a discount string."
                        break
                    }
                case FixedAmount:
                    if (quantity > claims) {
                        detailMessage = "There are not enough discounted Strings to cover the amount of quantity you have"
                        break
                    } else {
                        detailMessage = "there is a fixed amount here where quantity is less than claims"
                        break
                    }
            }
          return detailMessage
        }