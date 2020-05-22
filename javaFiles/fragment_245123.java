Elements methodName = doc.select("pre:contains(public), dl > dd > ol > li");

for (int i = 0; i < methodName.size(); i++) {
    if (methodName.get(i).tagName().equals("pre")) {        // if the <pre> tag
        if (methodName.get(i + 1).tagName().equals("li")) { // is followed by a <li> tag
            System.out.println(methodName.get(i).text());   // print it
        }
    } else System.out.println(methodName.get(i).text());    // else it is a <li> tag so print it
}