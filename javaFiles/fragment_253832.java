return driver.findElements(blogTitleLocator)
             .stream()
             .map(WebElement::getText) // convert to a Stream of String
             .filter(s -> s.equalsIgnoreCase(postMainTitle)) // accept only Strings
                                                             //equal to postMainTitle
             .count(); // count the elements of the Stream that passed the filter