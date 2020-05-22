AutoPilot searchProperties = new AutoPilot();
AutoPilot image = new AutoPilot(vn);
AutoPilot name = new AutoPilot(vn);
name.selectXPath("Name");
Image.selectXPath("values/PropertyValue");// should use relative path here, makes a huge difference in performance
 searchProperties.selectXPath("/BatchItemSearchResultAnswer/Result/SearchProperties/Content/Item");


      searchProperties.bind(nav);
        searchPro searchOption = new searchPro();
        while (searchProperties.evalXPath() != -1) {
            //reuser
            //name.resetXPath();

            searchOption.id = Id.evalXPathToString();
            searchOption.name = name.evalXPathToString();
            Log.e("SearchId", Id.evalXPathToString());
            Log.e("SearchName", name.evalXPathToString());


            searchOption.propertyList = new ArrayList();
            vn.push()
            while (Image.evalXPath() != -1) {
                property pro = new Property();
                pro.id = Id.evalXPathToString();
                Log.e("SearchPId", Id.evalXPathToString());
                Log.e("SearchPName", name.evalXPathToString());
                searchOption.propertyList.add(pro);
            }
            Image.resetXPath();
            vn.pop();
       }