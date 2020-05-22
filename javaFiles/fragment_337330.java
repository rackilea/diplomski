String menu = "1";
int menuint;
try {
    menuint = Integer.ParseInt (menu);
} catch (NumberFormatException e) {
    menuint = -1;
}
switch (menuint) {
   :