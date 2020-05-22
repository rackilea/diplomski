Element root = document.getRootElement();
        Namespace namespace = new Namespace("android", "http://schemas.android.com/apk/res/android");
        for(Iterator i = root.elementIterator("receiver"); i.hasNext();)
        {
            Element e = (Element)i.next();
            System.out.println(e.attributeValue("exported"));
            System.out.println(e.attributeValue(new QName("exported", namespace)));
        }