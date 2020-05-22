WebElement prev=null;
    boolean isSorted = true;
    for (WebElement currentWebElement : list) {

        if (prev == null) {
            prev = currentWebElement;
            continue;
        } else {

            if (Double.compare(Double.parseDouble(prev.getText().replaceAll(",", "")),
                    Double.parseDouble(currentWebElement .getText().replaceAll(",", ""))) > 0) {
                isSorted = false;
                break;
            }

            prev = currentWebElement;

        }

    }