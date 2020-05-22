In [16]: from selenium import webdriver

In [17]: driver = webdriver.Remote(desired_capabilities=webdriver.DesiredCapabilities.HTMLUNIT)

In [18]: driver.get("https://focus.nassau.k12.fl.us/focus/");

In [19]: el = driver.find_element_by_xpath("//input[@id='username-input']")

In [20]: el.send_keys("mcdonaldje")

In [21]: driver.current_url
Out[21]: u'https://focus.nassau.k12.fl.us/focus/'