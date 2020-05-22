XDocument doc = XDocument.Load("YourXmlFilePath");
XNamespace ns = "YourNameSpacegoesHere";

var query = from d in doc.Descendants(ns + "column")
            where d.Element(ns + "name").Value.ToString() == "DOCTYPE"                  
            select d;