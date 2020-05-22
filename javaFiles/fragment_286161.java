from selenium import webdriver

driver = webdriver.Chrome()
driver.get("http://zerohedge.talking-forex.com/live.html")
driver.switch_to_frame("content");
driver.find_element_by_css_selector(".ui-icon-closethick").click();