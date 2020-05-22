// Create a text area; you'll need to add it to your GUI, of course
 TextArea ta = new TextArea(20, 80);
 // This is a sort of adapter that lets Jess print into a textarea.
 // There's also a JTextAreaWriter for Swing GUIs
 TextAreaWriter taw = new TextAreaWriter(ta);
 // Create a rule engine instance
 Rete engine = new Rete();
 // Connect the "t" router to the TextArea. From this point on, 
 // Jess code that executes "(printout t ..." will send its output
 // to the TextArea
 engine.addOutputRouter("t", taw);