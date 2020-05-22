// Declare lists
DefaultListModel<String> lista1 = new DefaultListModel<String>();
ArrayList<String> variableList = new ArrayList<String>();
JList<String> jList = new JList<String>();

String result = "type(t1, t2)";

// Get string within parenthesis
result = result.substring(result.indexOf('(') + 1, result.indexOf(')'));

// Split into elements
String[] types = result.split(",");

// For each, add to list if not duplicate
for (int i = 0; i < types.length; i++) 
 { 
    String type = types[i].trim();
    if (!variableList.contains(type))
    { 
        variableList.add(type);
        lista1.addElement(type);
    }
 }

jList.setModel(lista1);

// Add to frame/revalidate/repaint as needed