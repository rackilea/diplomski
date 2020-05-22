int expected_value=86;
int numerical_value=0;
List<WebElement> lists = driver.findElements(By.cssSelector("span.ndocs"));

  for (int i = 0; i < lists.size(); ) {
            String trimmed_value = lists.get(i).getText();
            trimmed_value = lists.get(i).getText().trim().substring(trimmed_value.indexOf("(") + 1);
            trimmed_value = lists.get(i).getText().trim().substring(0, trimmed_value.indexOf(")"));
            System.out.println(trimmed_value);
            numerical_value =numerical_value+Integer.parseInt(trimmed_value);
            i++;
        }
assertEquals(expected_value, numerical_value);