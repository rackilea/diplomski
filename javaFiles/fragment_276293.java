public bool waitForElementPresent(string Xpath) {
bool present = false;
for (int second = 0; ; second++) {
if (second >= 5) {
break;
}
if (IsElementPresent(Xpath)) {
present = true;
break;
}
Thread.Sleep(1000);
}
return present;
}