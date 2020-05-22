public static void main(String[] args) {
Cookie cookie = new Cookie();
Vegetable vegetable = new Vegetable();
Dinner dinner = new Dinner(cookie, vegetable);
dinner.tryEverything();
}