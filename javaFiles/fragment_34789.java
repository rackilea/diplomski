String PAGE_1_KEY = "page 1";
String PAGE_2_KEY = "page 2";
// as many keys as you need

JFrame frame = ...;
frame.setLayout(new CardLayout());
frame.add(createPage1(), PAGE_1_KEY);
frame.add(createPage2(), PAGE_2_KEY);
// etc.