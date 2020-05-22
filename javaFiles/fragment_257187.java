Page1 page1 = new Page1();
Page2 page2 = new Page2();
page1.action1()
     .conditionalAction( page1 )
     .action1()
     .conditionalAction( page2 )
     .action2();