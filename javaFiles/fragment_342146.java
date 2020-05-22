<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html><head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Product Catalogue</title>
  <link rel="stylesheet" type="text/css" href="sortList/layout.css" />
  <script type="text/javascript" src="sortList/sort.js"></script>
  <script type="text/javascript">   
  //Puts the products into the product array of the catalogue object
    <%
        List<Integer> prdIDList = (List<Integer>) request.getAttribute("prodID");
        List<String> prdNAMEList = (List<String>) request.getAttribute("prodNAME");
        List<String> prdIMAGEList = (List<String>) request.getAttribute("prodIMAGE");
        List<Float> prdPRICEList = (List<Float>) request.getAttribute("prodPRICE");
        List<String> prdFEATUREList = (List<String>) request.getAttribute("prodFEATURE");

        for (int i = 0; i < prdIDList.size(); i++) {

            Integer prdID = prdIDList.get(i);
            String prdNAME = prdNAMEList.get(i);
            String prdIMAGE = prdIMAGEList.get(i);
            Float prdPRICE = prdPRICEList.get(i);
            String prdFEATURE = prdFEATUREList.get(i);
    %>      
    catalogue.product[<%=i%>] = {pId:<%=prdID%>, pImage:"<%=prdIMAGE%>", pName:"<%=prdNAME%>", pPrice:<%=prdPRICE%>, pFeature:"<%=prdFEATURE%>"};
    <%
        }
    %>
  </script></head>
  <body onload="catalogue.sortByName()">

  <button onclick="catalogue.sortById()">Sort By Id</button>
  <button onclick="catalogue.sortByName()">Sort By Name</button>
  <button onclick="catalogue.sortByPrice()">Sort By Price</button>

  <div id="container"><div id="mainitemlist"></div></div>

  </body></html>