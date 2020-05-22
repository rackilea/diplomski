for (Element el : allElements) {
    if (el.className().equals("needed-header")) {
        System.out.println(">>>>" + el.text() + "<<<<");
    } else if (el.className().equals("needed-sub-header")) {
        System.out.println(">>" + el.text() + "<<");
    } else{
        System.out.println(el.text());
    }
}