Document document = new Document(pdfDocument))
List qaList = new List();

ListItem item = new ListItem();
Paragraph paragraph = new Paragraph();
paragraph.add(new Text("Question 1? ").setBold())
         .add(new Text("Answer 1"))
         .setMarginTop(0).setMarginBottom(0);
item.add(paragraph);
qaList.add(item);
item = new ListItem();
paragraph = new Paragraph();
paragraph.add(new Text("Question 2? ").setBold())
         .add(new Text("Answer 2"))
         .setMarginTop(0).setMarginBottom(0);
item.add(paragraph);
qaList.add(item);

document.add(qaList);